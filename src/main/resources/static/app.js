const API = "http://localhost:8080/api/alumnos";

async function listar(){
    const rest = await fetch(API);
    const alumnos = await rest.json();

    let html = " ";

    alumnos.forEach(a => {
        html += `
            <tr>
            <td>${a.cedula}</td>
            <td>${a.nombre}</td>
            <td>${a.apellido}</td>
            <td>${a.direccion}</td>
            <td>${a.telefono}</td>
            <td>
                <button onclick="editar('${a.cedula}')" type="button">Editar</button>
                <button onclick="Eliminar('${a.cedula}')" type="button">Eliminar</button>
            </td>
            </tr>
        
        `;
    });

    document.getElementById("tbody").innerHTML = html;
}

// javascript
async function editar(cedula) {
    try {
        const res = await fetch(`${API}/${encodeURIComponent(cedula)}`);
        if (!res.ok) {
            throw new Error(`Error al obtener alumno: ${res.status}`);
        }
        const a = await res.json();

        // Rellenar campos del formulario (asegúrate que existan estos elementos en el DOM)
        const cedulaInput = document.getElementById("cedula");
        const nombreInput = document.getElementById("nombre");
        const apellidoInput = document.getElementById("apellido");
        const direccionInput = document.getElementById("direccion");
        const telefonoInput = document.getElementById("telefono");

        if (cedulaInput) cedulaInput.value = a.cedula ?? "";
        if (nombreInput) nombreInput.value = a.nombre ?? "";
        if (apellidoInput) apellidoInput.value = a.apellido ?? "";
        if (direccionInput) direccionInput.value = a.direccion ?? "";
        if (telefonoInput) telefonoInput.value = a.telefono ?? "";

        // Opcional: enfocar el primer campo editable
        if (nombreInput) nombreInput.focus();
    } catch (error) {
        console.error(error);
        alert("No se pudo cargar el alumno. Ver consola para más detalles.");
    }
}

async function Eliminar(cedula) {
    if (!confirm(`¿Eliminar alumno con cédula ${cedula}?`)) return;
    await fetch(`${API}/${(cedula)}`,{method: 'DELETE'});
    listar();
}


async function CrearAlumno(e){
    e.preventDefault();
    const alumno = {
        cedula: e.target.cedula.value,
        nombre: e.target.nombre.value,
        apellido: e.target.apellido.value,
        direccion: e.target.direccion.value,
        telefono: e.target.telefono.value
    };

    await fetch(API,
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(alumno)});
    listar();

}

listar();