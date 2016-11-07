var configuracion = require("../Source/Funcionalidad/Configuracion.js");
var sesion = require("../Source/Objetos/Sesion.js");
var horario = require("../Source/Objetos/Horario.js");
var grupo = require("../Source/Objetos/Grupo.js");
var asignatura = require("../Source/Objetos/Asignatura.js");

c = new configuracion();

iso = new asignatura("IS",3,"Informatica");
ia = new asignatura("IA",3,"Informatica");
pro = new asignatura("PR",3,"Informatica");
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
g = new grupo("Informatica",1,"Hola")
h.setGrupo(g);
h.setSesiones(c.getSesiones());
h.generar();
c.anadirHorario(h);

h2 = new horario();
g2 = new grupo("Informatica",2,"Hola")
h2.setGrupo(g2);
h2.setSesiones(c.getSesiones());
h2.generar();
c.anadirHorario(h2);

horarios = c.getHorarios();
horarios[0].imprimir();
horarios[1].imprimir();