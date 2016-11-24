profesor = require("../Objetos/Profesor.js");
asignatura = require("../Objetos/Asignatura.js");
curso = require("../Objetos/Curso.js");
sesion = require("../Objetos/Sesion.js");

var fabrica = function (configuracion) {

    this.c = configuracion;

    this.fabricar = function (tipo, datos) {
        switch (tipo) {
            case "Profesor":
                configuracion.anadirProfesor(new profesor(datos.nombre, datos.min, datos.max));
                break;
            case "Asignatura":
                configuracion.anadirAsignatura(new asignatura(datos.nombre, datos.curso, datos.titulacion, this.c.getProfesorPorNombre(datos.profesor)));
                break;
            case "Curso":
                configuracion.anadirCurso(new curso(datos.nombre, datos.curso, datos.titulacion));
                break;
            case "Sesion":
                //console.log(datos);
                 configuracion.anadirSesion(new sesion(this.c.getAsignaturaPorNombre(datos.asignatura), datos.horas, this.c.getCursoPorNombre(datos.curso)));
                break;
        }
    }
}

module.exports = fabrica;
