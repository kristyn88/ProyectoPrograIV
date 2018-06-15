
var nCategoria = 1;
var nSubcategoria = 1;
var nivel = 1;

function init() {
    cargarCategorias();
    cargarSubCategorias(nCategoria);
    console.log("Inicializando....");
}

function cargarCategorias() {
    loadJSON(actualizarCategorias, "ServicioCategorias");
}

function cargarSubCategorias(categoria) {
loadJSON(actualizarSubCategorias, "ServicioSubCategorias?categoria="+String(categoria));
}

function actualizarCategorias(textJSON) {
    var datos = JSON.parse(textJSON);
    var refMenu = document.getElementById("categoria");
    if (refMenu) {
        refMenu.options.length = 0;
        for (var i = 0; i < datos.caracteristicas.length; i++) {
            var opt = document.createElement("OPTION");
            opt.setAttribute("value", datos.caracteristicas[i].valor);
            if (i === 0) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(datos.caracteristicas[i].texto));
            refMenu.appendChild(opt);
        }
    }
}

function actualizarSubCategorias(textJSON) {
    var datos = JSON.parse(textJSON);
    var refMenu = document.getElementById("subcategoria");
    if (refMenu) {
        refMenu.options.length = 0;
        for (var i = 0; i < datos.subcategoria.length; i++) {
            var opt = document.createElement("OPTION");
            opt.setAttribute("value", datos.subcategoria[i].valor);
            if (i === 0) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(datos.subcategoria[i].texto));
            refMenu.add(opt);
        }
    }
}

function cargarPendientes(){
    loadJSON(cargarOpciones2, "Autorizar");
}

function cargarOferentesPendientes(){
    loadJSON(cargarOpciones3, "AutorizarOf");
}

function cargarOpciones(textoJSON) {
    datos = JSON.parse(textoJSON);//Datos no es un array, es un objeto con un array

    var refMenu = document.getElementById("categorias");
    var refMenu2 = document.getElementById("subCategorias");


    while (refMenu.length > 0) {
        refMenu.remove(refMenu.length - 1);
    }
    if (refMenu) {
        for (var i = 0; i < datos.opciones.length; i++) {
            var nuevaOpcion = document.createElement("OPTION");
            nuevaOpcion.setAttribute("value", datos.opciones[i].valor);
            nuevaOpcion.appendChild(document.createTextNode(datos.opciones[i].texto));
            refMenu.appendChild(nuevaOpcion);
        }
    }

    while (refMenu2.length > 0) {
        refMenu2.remove(refMenu2.length - 1);
    }
    if (refMenu2) {
        for (var i = 0; i < datos.opciones2.length; i++) {
            var nuevaOpcion = document.createElement("OPTION");
            nuevaOpcion.setAttribute("value", datos.opciones2[i].valor);
            nuevaOpcion.appendChild(document.createTextNode(datos.opciones2[i].texto));
            refMenu.appendChild(nuevaOpcion);
        }
    }

    var nombre = document.getElementById("error");
    if (nombre) {
        nombre.innerHTML = datos.nombre.texto;
    }
    
}



function cargarOpciones2(textoJSON) {
    datos = JSON.parse(textoJSON);//Datos no es un array, es un objeto con un array

    var refTabla = document.getElementById("bodyAutorizarE");

    if (refTabla) {

        refTabla.innerHTML = "";

        for (var i = 0; i < datos.opciones.length; i++) {
                var nuevaFila = refTabla.insertRow(-1);
                
                var nuevaCelda = nuevaFila.insertCell(-1);
                var checkbox = document.createElement("INPUT");
                checkbox.type = "checkbox";
                checkbox.id = datos.opciones[i].id;
                nuevaCelda.appendChild(checkbox);
                //Celda del checkbox
                
                var nuevaCelda1 = nuevaFila.insertCell(-1);
                nuevaCelda1.innerHTML = datos.opciones[i].id;
                var nuevaCelda2 = nuevaFila.insertCell(-1);
                nuevaCelda2.innerHTML = datos.opciones[i].nombre;
                var nuevaCelda3 = nuevaFila.insertCell(-1);
                nuevaCelda3.innerHTML = datos.opciones[i].localizacion;
                var nuevaCelda4 = nuevaFila.insertCell(-1);
                nuevaCelda4.innerHTML = datos.opciones[i].correo;
                var nuevaCelda5 = nuevaFila.insertCell(-1);
                nuevaCelda5.innerHTML = datos.opciones[i].telefono;
                var nuevaCelda6 = nuevaFila.insertCell(-1);
                nuevaCelda6.innerHTML = datos.opciones[i].descripcion;
                var nuevaCelda7 = nuevaFila.insertCell(-1);
                nuevaCelda7.innerHTML = datos.opciones[i].clave;
                var nuevaCelda8 = nuevaFila.insertCell(-1);
                nuevaCelda8.innerHTML = datos.opciones[i].fechaRegistro;
                var nuevaCelda9 = nuevaFila.insertCell(-1);
                nuevaCelda9.innerHTML = datos.opciones[i].estado;
                var nuevaCelda10 = nuevaFila.insertCell(-1);
                nuevaCelda10.innerHTML = datos.opciones[i].usuario;
        }
        if(datos.opciones.length<1){
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda10 = nuevaFila.insertCell(-1);
            nuevaCelda10.innerHTML = "No hay empresas pendientes...";
        }
    }
}


function cargarOpciones3(textoJSON) {
    datos = JSON.parse(textoJSON);//Datos no es un array, es un objeto con un array

    var refTabla = document.getElementById("bodyAutorizarO");

    if (refTabla) {

        refTabla.innerHTML = "";

        for (var i = 0; i < datos.opciones.length; i++) {
                var nuevaFila = refTabla.insertRow(-1);
                
                var nuevaCelda = nuevaFila.insertCell(-1);
                var checkbox = document.createElement("INPUT");
                checkbox.type = "checkbox";
                checkbox.id = datos.opciones[i].id;
                nuevaCelda.appendChild(checkbox);
                //Celda del checkbox
                
                var nuevaCelda1 = nuevaFila.insertCell(-1);
                nuevaCelda1.innerHTML = datos.opciones[i].id;
                var nuevaCelda2 = nuevaFila.insertCell(-1);
                nuevaCelda2.innerHTML = datos.opciones[i].nombre;
                var nuevaCelda3 = nuevaFila.insertCell(-1);
                nuevaCelda3.innerHTML = datos.opciones[i].apellido;
                var nuevaCelda4 = nuevaFila.insertCell(-1);
                nuevaCelda4.innerHTML = datos.opciones[i].nacionalidad;
                var nuevaCelda5 = nuevaFila.insertCell(-1);
                nuevaCelda5.innerHTML = datos.opciones[i].telefono;
                var nuevaCelda6 = nuevaFila.insertCell(-1);
                nuevaCelda6.innerHTML = datos.opciones[i].correo;
                var nuevaCelda7 = nuevaFila.insertCell(-1);
                nuevaCelda7.innerHTML = datos.opciones[i].residencia;
                var nuevaCelda8 = nuevaFila.insertCell(-1);
                nuevaCelda8.innerHTML = datos.opciones[i].estado;
                var nuevaCelda9 = nuevaFila.insertCell(-1);
                nuevaCelda9.innerHTML = datos.opciones[i].usuario;
        }
        if(datos.opciones.length<1){
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda10 = nuevaFila.insertCell(-1);
            nuevaCelda10.innerHTML = "No hay oferentes pendientes...";
        }
    }
}


function mandarAutorizacionEmpresa(){
    var refTable = document.getElementById("bodyAutorizarE");
    var tipo ="1";//Tipo de autorizacion para empresas
    if(refTable){
        for(var i = 0; i < refTable.rows.length; i++){
            var cellsOfRow = refTable.rows[i].getElementsByTagName('td');
            var check = cellsOfRow[0];
            if(check.firstChild.checked === true){
                console.log(check.firstChild.id);
                enviarIdAutorizado(check.firstChild.id,tipo);
            }
            cargarPendientes();
        }
    }
}

function mandarAutorizacionOferente(){
    var refTable = document.getElementById("bodyAutorizarO");
    var tipo ="2";//Tipo de autorizacion para oferentes
    if(refTable){
        for(var i = 0; i < refTable.rows.length; i++){
            var cellsOfRow = refTable.rows[i].getElementsByTagName('td');
            var check = cellsOfRow[0];
            if(check.firstChild.checked === true){
                console.log(check.firstChild.id);
                enviarIdAutorizado(check.firstChild.id,tipo);
            }
            cargarOferentesPendientes();
        }
    }
}

function procesarDatos(texto) {
    console.log(texto);
    var refInfo = document.getElementById('info');
    if (refInfo) {
        refInfo.innerHTML = "Via POST Request: " + texto;
    }
}

function enviarIdAutorizado(num, tipo) {

    var xobj = new XMLHttpRequest();
    xobj.open('POST', 'ServicioAutorizar', true);

    var dato1 = num;

    var datos = new FormData();
    datos.append('num', dato1);
    datos.append('tipo',tipo);

    xobj.onreadystatechange = function () {
        if (xobj.readyState === 4 && xobj.status === 200) {
            procesarDatos(xobj.responseText);
        }
    };
    var txtDatos = "";
    for (var k of datos.keys()) {
        if (!(!txtDatos || 0 === txtDatos.length)) {
            txtDatos += "&";
        }
        txtDatos += k + "=" + datos.get(k);
    }
    xobj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xobj.send(txtDatos);
    return false;
}
