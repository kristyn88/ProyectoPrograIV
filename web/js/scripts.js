function init() {
    loadJSON(cargarOpciones, "RegistroRequerimientos1");
    console.log("Inicializando....");
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
    if(nombre){
        nombre.innerHTML = datos.nombre.texto;
    }
    
}