var configuracion = require("../Source/Funcionalidad/Configuracion.js");
var sesion = require("../Source/Objetos/Sesion.js");
var horario = require("../Source/Objetos/Horario.js");
var asignatura = require("../Source/Objetos/Asignatura.js");

c = new configuracion();

iso = new asignatura("IS",3,"Informatica");
ia = new asignatura("IA",3,"Informatica");
pro = new asignatura("Proyectos",3,"Informatica");
isi = new asignatura("ISI",3,"Informatica");
si = new asignatura("SI",3,"Informatica")
c.anadirSesion(new sesion(iso,2,3));
c.anadirSesion(new sesion(iso,2,3));
c.anadirSesion(new sesion(iso,2,3));
c.anadirSesion(new sesion(ia,2,3));
c.anadirSesion(new sesion(ia,2,3));
c.anadirSesion(new sesion(ia,2,3));
c.anadirSesion(new sesion(pro,2,3));
c.anadirSesion(new sesion(pro,2,3));
c.anadirSesion(new sesion(isi,2,3));
c.anadirSesion(new sesion(isi,2,3));
c.anadirSesion(new sesion(si,2,3));
c.anadirSesion(new sesion(si,2,3));


h = new horario();
h.setGrupo("Informatica");
h.setSesiones(c.getSesiones());
h.generar();
h.imprimir();