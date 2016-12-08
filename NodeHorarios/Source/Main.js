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

var Main = function() {

    comprobar = new comprobaciones();
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    leer.leer();

    h = new horario();
    g = new grupo("Informatica 3", c.getCursoPorNombre("Informatica 3"));
    h.setGrupo(g);
    h.setSesiones(c.getSesionesPorNombreCurso("Informatica 3"));
    h.generar();
    c.anadirHorario(h);
    //----------------
    h.setSesiones(c.getSesionesPorNombreCurso("Informatica 3"));
    h.generar();
    c.anadirHorario(h);
    //-------------------
    h.setSesiones(c.getSesionesPorNombreCurso("Informatica 3"));
    h.generar();
    c.anadirHorario(h);
    //h.imprimir();
    console.log("El numero de horarios es: "+c.getHorariosDeUnGrupo("Informatica 3").length);
    c.getHorariosDeUnGrupo("Informatica 3").forEach(function(element) {
        comprobar.valorar(element);
    });
    c.aceptarHorario("Informatica 3");

    h2 = new horario();
    g2 = new grupo("Informatica 2", c.getCursoPorNombre("Informatica 2"));
    h2.setGrupo(g2);
    h2.setSesiones(c.getSesionesPorNombreCurso("Informatica 2"));
    h2.generar();
    c.anadirHorario(h2);
    //----------------------
    h2.setSesiones(c.getSesionesPorNombreCurso("Informatica 2"));
    h2.generar();
    c.anadirHorario(h2);
    //----------------------
    h2.setSesiones(c.getSesionesPorNombreCurso("Informatica 2"));
    h2.generar();
    c.anadirHorario(h2);    
    c.getHorariosDeUnGrupo("Informatica 2").forEach(function (element) {
        comprobar.valorar(element);
    });
    c.aceptarHorario("Informatica 2");

    this.generarHorarioParaMostrar = function(numero) {
        h = c.getHorarios()[0];
        horarioEnviar = {}
        Object.keys(h.horarioGenerado).forEach(function(element) {
            try {
                horarioEnviar[element] = h.horarioGenerado[element].getAsignatura().getNombre();
            } catch (err) { }
        });
        return horarioEnviar;
    }
}

module.exports = Main;