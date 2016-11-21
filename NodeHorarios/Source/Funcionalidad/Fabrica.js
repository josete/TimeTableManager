profesor = require("../Objetos/Profesor.js");
asignatura = require("../Objetos/Asignatura.js");
curso = require("../Objetos/Curso.js");
sesion = require("../Objetos/Sesion.js");

var fabrica = function (configuracion) {

    this.c = configuracion;

    this.fabricar = function (tipo, datos) {
        objeto = null;
        switch (tipo) {
            case "Profesor":
                objeto = new profesor(datos.nombre, datos.min, datos.max);
                break;
            case "Asignatura":
                objeto = new asignatura(datos.nombre, datos.curso, datos.titulacion, c.getProfesorPorNombre(datos.profesor));
                break;
            case "Curso":
                objeto = new curso(datos.nombre, datos.curso, datos.titulacion);
                break;
            case "Sesion":
                objeto = new sesion(c.getAsignaturaPorNombre(datos.asignatura), datos.horas, c.getCursoPorNombre(datos.curso));
                break;
        }
        return objeto;
    }
}

module.exports = fabrica;
