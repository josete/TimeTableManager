var configuracion = require("./Funcionalidad/Configuracion.js");
var sesion = require("./Objetos/Sesion.js");
var horario = require("./Objetos/Horario.js");
var grupo = require("./Objetos/Grupo.js");
var asignatura = require("./Objetos/Asignatura.js");
var curso = require("./Objetos/Curso.js");
var profesor = require("./Objetos/Profesor.js");
var leerExcel = require("./Funcionalidad/LeerExcel.js");
var comprobaciones = require("./Funcionalidad/Comprobaciones.js");

var Main = function () {

    comprobar = new comprobaciones();
    c = new configuracion();
    leer = new leerExcel("../Info.xlsx", c);
    //Creo que hay que hacerlo asincrono
    //leer.leer();

    raul = new profesor("Raul");
    mariano = new profesor("Mariano");
    paloma = new profesor("Paloma");
    joseM = new profesor("Jose Manuel");
    angel = new profesor("Angel");
    guillermo = new profesor("Guillermo");
    cristina = new profesor("Cristina");
    teo = new profesor("Teo");
    rodrigo = new profesor("Rodrigo");
    gl = new profesor("GL");
    //---------------------------------
    iso = new asignatura("IS", 3, "Informatica", raul);
    ia = new asignatura("IA", 3, "Informatica", raul);
    pro = new asignatura("PR", 3, "Informatica", joseM);
    isi = new asignatura("ISI", 3, "Informatica", paloma);
    si = new asignatura("SI", 3, "Informatica", angel);
    //*************
    met = new asignatura("MET", 2, "Informatica", guillermo);
    est = new asignatura("EST", 2, "Informatica", raul);
    red = new asignatura("RED", 2, "Informatica", teo);
    bd = new asignatura("BD", 2, "Informatica", rodrigo);
    arq = new asignatura("ARQ", 2, "Informatica", gl);
    //-------------------------------------------------
    infor3 = new curso("Informatica", 3, "Informatica");
    infor2 = new curso("Informatica", 2, "Informatica");
    //---------------------------------------
    c.anadirSesion(new sesion(iso, 2, infor3));
    c.anadirSesion(new sesion(iso, 2, infor3));
    c.anadirSesion(new sesion(iso, 2, infor3));
    c.anadirSesion(new sesion(ia, 2, infor3));
    c.anadirSesion(new sesion(ia, 2, infor3));
    c.anadirSesion(new sesion(ia, 2, infor3));
    c.anadirSesion(new sesion(pro, 2, infor3));
    c.anadirSesion(new sesion(pro, 2, infor3));
    c.anadirSesion(new sesion(isi, 2, infor3));
    c.anadirSesion(new sesion(isi, 2, infor3));
    c.anadirSesion(new sesion(si, 2, infor3));
    c.anadirSesion(new sesion(si, 2, infor3));
    //*************
    c.anadirSesion(new sesion(est, 2, infor2));
    c.anadirSesion(new sesion(est, 2, infor2));
    c.anadirSesion(new sesion(est, 2, infor2));
    c.anadirSesion(new sesion(met, 2, infor2));
    c.anadirSesion(new sesion(met, 2, infor2));
    c.anadirSesion(new sesion(arq, 2, infor2));
    c.anadirSesion(new sesion(arq, 2, infor2));
    c.anadirSesion(new sesion(bd, 2, infor2));
    c.anadirSesion(new sesion(bd, 2, infor2));
    c.anadirSesion(new sesion(red, 2, infor2));
    c.anadirSesion(new sesion(red, 2, infor2));
    c.anadirSesion(new sesion(red, 2, infor2));
    //----------------------------------

    h = new horario();
    g = new grupo("Informatica", c.getCursoPorNombre("Informatica 3"));
    h.setGrupo(g);
    h.setSesiones(c.getSesionesPorNombreCurso("Informatica 3"));
    h.generar();
    c.anadirHorario(h);
    h.imprimir();

    var a = [];
    Object.keys(h.horarioGenerado).forEach(function(element){
        try{
        var final =element.split("-")[0]+"-"+(parseInt("10",element.split("-")[1])+parseInt("10",h.horarioGenerado[element].horas));
        a.push(comprobar.comprobarSolape(h.horarioGenerado[element].getAsignatura().getProfesor(),element,final));        
        }catch(err){}
    });
    h.valor = Math.min.apply(Math,a);
    console.log("Valor: "+h.valor);

    //this.comprobar.comprobarSolape();

    h2 = new horario();
    g2 = new grupo("Informatica", c.getCursoPorNombre("Informatica 2"));
    h2.setGrupo(g2);
    h2.setSesiones(c.getSesionesPorNombreCurso("Informatica 2"));
    h2.generar();
    c.anadirHorario(h2);
    h2.imprimir();
    Object.keys(h2.horarioGenerado).forEach(function(element){
        try{
        var final =element.split("-")[0]+"-"+(parseInt("10",element.split("-")[1])+parseInt("10",h.horarioGenerado[element].horas));
        a.push(comprobar.comprobarSolape(h.horarioGenerado[element].getAsignatura().getProfesor(),element,final));
        }catch(err){}
    });
    h2.valor = Math.min.apply(Math,a);
    console.log("Valor: "+h2.valor);

    /*console.log("Horario de Raul: ");
    c.getHorarioProfesor("Raul").imprimir();
    horarios = c.getHorarios();
    horarios[0].imprimir();
    horarios[1].imprimir();*/

    this.generarHorarioParaMostrar = function(numero){
        h = c.getHorarios()[0];
        horarioEnviar = {}
        Object.keys(h.horarioGenerado).forEach(function(element){
            try{
               horarioEnviar[element]=h.horarioGenerado[element].getAsignatura().getNombre();
            }catch(err){}
        });
        return horarioEnviar;
    }
}

module.exports = Main;