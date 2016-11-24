var configuracion = require("./Funcionalidad/Configuracion.js");
var sesion = require("./Objetos/Sesion.js");
var horario = require("./Objetos/Horario.js");
var grupo = require("./Objetos/Grupo.js");
var asignatura = require("./Objetos/Asignatura.js");
var curso = require("./Objetos/Curso.js");
var profesor = require("./Objetos/Profesor.js");
var leerExcel = require("./Funcionalidad/LeerExcel.js");

c = new configuracion();
leer = new leerExcel("../Info.xlsx", c);
leer.leer();

/*raul = new profesor("Raul");
mariano = new profesor("Mariano");
paloma = new profesor("Paloma");
joseM = new profesor("Jose Manuel");
angel = new profesor("Angel");
guillermo = new profesor("Guillermo");
cristina = new profesor("Cristina");
teo = new profesor("Teo");
rodrigo =  new profesor("Rodrigo");
gl = new profesor("GL");
//---------------------------------
iso = new asignatura("IS",3,"Informatica",raul);
ia = new asignatura("IA",3,"Informatica",mariano);
pro = new asignatura("PR",3,"Informatica",joseM);
isi = new asignatura("ISI",3,"Informatica",paloma);
si = new asignatura("SI",3,"Informatica",angel);
//*************
met = new asignatura("MET",2,"Informatica",guillermo);
est = new asignatura("EST",2,"Informatica",raul);
red = new asignatura("RED",2,"Informatica",teo);
bd = new asignatura("BD",2,"Informatica",rodrigo);
arq = new asignatura("ARQ",2,"Informatica",gl);
//-------------------------------------------------
infor3 = new curso("Informatica",3,"Informatica");
infor2 = new curso("Informatica",2,"Informatica");
//---------------------------------------
c.anadirSesion(new sesion(iso,2,infor3));
c.anadirSesion(new sesion(iso,2,infor3));
c.anadirSesion(new sesion(iso,2,infor3));
c.anadirSesion(new sesion(ia,2,infor3));
c.anadirSesion(new sesion(ia,2,infor3));
c.anadirSesion(new sesion(ia,2,infor3));
c.anadirSesion(new sesion(pro,2,infor3));
c.anadirSesion(new sesion(pro,2,infor3));
c.anadirSesion(new sesion(isi,2,infor3));
c.anadirSesion(new sesion(isi,2,infor3));
c.anadirSesion(new sesion(si,2,infor3));
c.anadirSesion(new sesion(si,2,infor3));
//*************
c.anadirSesion(new sesion(est,2,infor2));
c.anadirSesion(new sesion(est,2,infor2));
c.anadirSesion(new sesion(est,2,infor2));
c.anadirSesion(new sesion(met,2,infor2));
c.anadirSesion(new sesion(met,2,infor2));
c.anadirSesion(new sesion(arq,2,infor2));
c.anadirSesion(new sesion(arq,2,infor2));
c.anadirSesion(new sesion(bd,2,infor2));
c.anadirSesion(new sesion(bd,2,infor2));
c.anadirSesion(new sesion(red,2,infor2));
c.anadirSesion(new sesion(red,2,infor2));
c.anadirSesion(new sesion(red,2,infor2));
//----------------------------------*/
h = new horario();
g = new grupo("Informatica",c.getCursoPorNombre("Informatica 3"));
h.setGrupo(g);
h.setSesiones(c.getSesionesPorCurso(c.getCursoPorNombre("Informatica 3")));
h.generar();
c.anadirHorario(h);
h.imprimir();

/*h2 = new horario();
g2 = new grupo("Informatica",infor2)
h2.setGrupo(g2);
h2.setSesiones(c.getSesionesPorCurso(infor2));
h2.generar();
c.anadirHorario(h2);
h2.imprimir();*/

console.log("Horario de Raul: ");
c.getHorarioProfesor("Raul").imprimir();
/*horarios = c.getHorarios();
horarios[0].imprimir();
horarios[1].imprimir();*/