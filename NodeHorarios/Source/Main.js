var configuracion = require("../Source/Funcionalidad/Configuracion.js");
var sesion = require("../Source/Objetos/Sesion.js");
var horario = require("../Source/Objetos/Horario.js");

c = new configuracion();
c.anadirSesion(new sesion("IS",2,3));
c.anadirSesion(new sesion("IS",2,3));
c.anadirSesion(new sesion("IS",2,3));
c.anadirSesion(new sesion("IA",2,3));
c.anadirSesion(new sesion("IA",2,3));

h = new horario();
h.setGrupo("Informatica");
h.setSesiones(c.getSesiones());
h.generar();