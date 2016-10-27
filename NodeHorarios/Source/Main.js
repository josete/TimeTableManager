var configuracion = require("../Source/Funcionalidad/Configuracion.js");
var sesion = require("../Source/Objetos/Sesion.js");
var horario = require("../Source/Objetos/Horario.js");
var asignatura = require("../Source/Objetos/Asignatura.js");

c = new configuracion();

c.anadirSesion(new sesion(new asignatura("IS",3,"Informatica"),2,3));
c.anadirSesion(new sesion(new asignatura("IS",3,"Informatica"),2,3));
c.anadirSesion(new sesion(new asignatura("IS",3,"Informatica"),2,3));
c.anadirSesion(new sesion(new asignatura("IA",3,"Informatica"),2,3));
c.anadirSesion(new sesion(new asignatura("IA",3,"Informatica"),2,3));

h = new horario();
h.setGrupo("Informatica");
h.setSesiones(c.getSesiones());
h.generar();
h.imprimir();