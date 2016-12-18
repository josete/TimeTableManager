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

    for (var j = 0; j < c.cursos.length; j++) {
        for (var i = 0; i < 30; i++) {
            generarHorario(c.cursos[j].nombre, c.cursos[j].curso, c.horas[c.cursos[j].nombre + " " + c.cursos[j].curso]);
        }
        console.log("El numero de horarios es: " + c.getHorariosDeUnGrupo(c.cursos[j].nombre + " " + c.cursos[j].curso).length);
        c.getHorariosDeUnGrupo(c.cursos[j].nombre + " " + c.cursos[j].curso).forEach(function (element) {
            comprobar.valorar(element);
        });
        c.aceptarHorario(c.cursos[j].nombre + " " + c.cursos[j].curso);
    }

    this.generarHorarioParaMostrar = function (numero) {
        h = c.getHorariosValidos();
        horarioEnviar = {}
        for (var k = 0; k < h.length; k++) {
            horario = {};
            horario["nombre"]=h[k].grupo.nombre;
            for (var j = 8; j < 14; j += 2) {
                var tr = "<tr><td>" + j + "</td>";
                for (var i = 0; i < h[k].horarioGenerado["Dias"]; i++) {
                    try {
                        tr += "<td>" + h[k].horarioGenerado[i + "-" + j].getAsignatura().getNombre() + "</td>";
                    } catch (err) {
                        tr += "<td></td>";
                    }
                }
                tr += "</tr>";
                horario[j] = tr;
            }
            horarioEnviar[k] = horario;
        }
        return horarioEnviar;
    }

    function generarHorario(titulacion, curso, horas) {
        h = new horario();
        g = new grupo((titulacion + " " + curso), c.getCursoPorNombre((titulacion + " " + curso)));
        h.setGrupo(g);
        h.setSesiones(c.getSesionesPorNombreCurso((titulacion + " " + curso)));
        if (horas != null) {
            h.setHorasDias(horas);
        }
        h.generar();
        c.anadirHorario(h);
    }
}
module.exports = Main;