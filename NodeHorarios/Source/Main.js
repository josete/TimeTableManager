var configuracion = require("./Funcionalidad/Configuracion.js");
var sesion = require("./Objetos/Sesion.js");
var horario = require("./Objetos/Horario.js");
var grupo = require("./Objetos/Grupo.js");
var asignatura = require("./Objetos/Asignatura.js");
var curso = require("./Objetos/Curso.js");
var profesor = require("./Objetos/Profesor.js");
var leerExcel = require("./Funcionalidad/LeerExcel.js");
var comprobaciones = require("./Funcionalidad/Comprobaciones.js");
var async = require("async");

var Main = function () {

    comprobar = new comprobaciones();
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();

    for(var i=0;i<20;i++){
        generarHorario("Informatica",3);    
    }
    console.log("El numero de horarios es: " + c.getHorariosDeUnGrupo("Informatica 3").length);
    c.getHorariosDeUnGrupo("Informatica 3").forEach(function (element) {
        comprobar.valorar(element);
    });
    c.aceptarHorario("Informatica 3");

    for(var i=0;i<20;i++){
        generarHorario("Informatica",2);    
    }
    console.log("El numero de horarios es: " + c.getHorariosDeUnGrupo("Informatica 2").length);
    c.getHorariosDeUnGrupo("Informatica 2").forEach(function (element) {
        comprobar.valorar(element);
    });
    c.aceptarHorario("Informatica 2");

    this.generarHorarioParaMostrar = function (numero) {
        h = c.getHorariosValidos()[0];
        horarioEnviar = {}
        Object.keys(h.horarioGenerado).forEach(function (element) {
            try {
                horarioEnviar[element] = h.horarioGenerado[element].getAsignatura().getNombre();
            } catch (err) { }
        });
        return horarioEnviar;
    }

    function generarHorario(titulacion, curso) {
        h = new horario();
        g = new grupo((titulacion + " " + curso), c.getCursoPorNombre((titulacion + " " + curso)));
        h.setGrupo(g);
        h.setSesiones(c.getSesionesPorNombreCurso((titulacion + " " + curso)));
        h.setHorasDias([6,4,4,4,6]);
        h.generar();
        c.anadirHorario(h);
    }
}
module.exports = Main;