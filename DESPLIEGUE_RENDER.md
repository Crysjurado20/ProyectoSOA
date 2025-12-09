# 🚀 Plan de Despliegue en Render

## 📋 Resumen
Despliegue de aplicación Spring Boot + MySQL en Render usando contenedores Docker.

---

## 🎯 Opción 1: Despliegue Simplificado (RECOMENDADO)

### **Usar Base de Datos Externa (PostgreSQL o MySQL de Render)**

Render ofrece PostgreSQL gratuito. Es la forma MÁS FÁCIL y RÁPIDA.

### Pasos:

#### 1️⃣ Crear Base de Datos en Render

1. Ve a https://dashboard.render.com
2. Clic en **"New +"** → **"PostgreSQL"** (GRATIS)
3. Configura:
   - **Name:** `alumnos-db`
   - **Database:** `soa`
   - **User:** (se genera automáticamente)
   - **Region:** Oregon (Free)
4. Clic en **"Create Database"**
5. **GUARDA** la URL de conexión externa (External Database URL)

#### 2️⃣ Modificar Aplicación para PostgreSQL

Editar `pom.xml` - Agregar dependencia PostgreSQL:

```xml
<!-- Cambiar MySQL por PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

#### 3️⃣ Actualizar application.properties

```properties
# Database Configuration para PostgreSQL
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate para PostgreSQL
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

#### 4️⃣ Desplegar Aplicación en Render

1. En Render Dashboard → **"New +"** → **"Web Service"**
2. Conecta tu repositorio GitHub
3. Configura:
   - **Name:** `alumnos-app`
   - **Region:** Oregon (Free)
   - **Branch:** `main`
   - **Runtime:** `Docker`
   - **Docker Build Context Directory:** `.` (raíz)
   - **Dockerfile Path:** `./Dockerfile`

4. **Environment Variables:**
   ```
   DATABASE_URL=<URL externa de tu base de datos Render>
   DATABASE_USER=<usuario generado>
   DATABASE_PASSWORD=<contraseña generada>
   PORT=8080
   SPRING_PROFILES_ACTIVE=prod
   ```

5. **Plan:** Free
6. Clic en **"Create Web Service"**

#### 5️⃣ Esperar Despliegue
- Primera vez: 5-10 minutos
- Render construirá la imagen Docker
- Iniciará la aplicación
- Obtendrás una URL: `https://alumnos-app-xxxx.onrender.com`

---

## 🎯 Opción 2: Con MySQL en Render (Más Complejo)

### **Usar Docker Compose no es posible en el plan gratuito de Render**

Si necesitas MySQL específicamente, tendrías que:

1. **Usar servicio MySQL externo:**
   - Railway (tiene plan gratuito con MySQL)
   - PlanetScale (MySQL serverless gratuito)
   - Clever Cloud (MySQL gratuito limitado)

2. **Configurar variables de entorno** con la URL del MySQL externo

---

## 📝 Archivos Actualizados

✅ `Dockerfile` - Optimizado para producción  
✅ `docker-compose.yml` - Para desarrollo local  
✅ `init-db.sql` - Script de inicialización  
✅ `.dockerignore` - Ignorar archivos innecesarios  
✅ `application.properties` - Puerto dinámico `${PORT:8080}`  
✅ `render.yaml` - Blueprint de configuración (opcional)

---

## 🔧 Comandos Útiles

### Probar localmente con Docker:
```bash
# Construir imagen
docker build -t alumnos-app .

# Ejecutar contenedor
docker run -p 8080:8080 \
  -e DATABASE_URL=jdbc:mysql://host:3306/soa \
  -e DATABASE_USER=user \
  -e DATABASE_PASSWORD=pass \
  alumnos-app
```

### Con Docker Compose (local):
```bash
docker-compose up --build
```

---

## ⚠️ Consideraciones Importantes

### Plan Gratuito de Render:
- ✅ 750 horas/mes de servicio web
- ✅ PostgreSQL incluido (1 GB)
- ✅ SSL automático
- ⚠️ Hibernación después de 15 min inactividad
- ⚠️ Primer request después de hibernar es lento (30-60s)
- ❌ NO soporta Docker Compose
- ❌ NO incluye MySQL gratuito

### Alternativas si necesitas MySQL:
1. **Railway** - MySQL gratuito + despliegue Docker
2. **PlanetScale** - MySQL serverless + Render para app
3. **Usar PostgreSQL** - Más fácil en Render

---

## 🎁 Recomendación Final

**Para empezar YA:**

1. Usa PostgreSQL de Render (es gratis y fácil)
2. Cambia la dependencia en `pom.xml`
3. Actualiza `application.properties`
4. Despliega en Render
5. ¡Listo en 10 minutos!

**¿Quieres que te ayude con alguna de estas opciones específicamente?**
