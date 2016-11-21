profesor = require("../Objetos/Profesor.js");
asignatura = require("../Objetos/Asignatura.js");

var fabrica = function (configuracion) {

    this.c = configuracion;

    this.fabricar = function (tipo, datos) {
        objeto = null;
        switch (tipo) {
            case "Profesor":
                objeto = new profesor(datos.nombre, datos.min, datos.max);
                break;
            case "Asignatura":
                objeto = new asignatura(datos.nombre,datos.curso,datos.titulacion,c.getProfesorPorNombre(datos.profesor));
                break;
        }
        return objeto;
    }
}

module.exports = fabrica;