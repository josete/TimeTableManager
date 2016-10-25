var configuracion = require("../Source/Funcionalidad/Configuracion.js");
var sesion = require("../Source/Objetos/Sesion.js");

exports.testConfiguracionVacia = function(test){
    c = new configuracion();
    test.ok(c.isVacia());
    test.done();
}

exports.testGuardarSesionEnConfiguracion = function(test){
    c = new configuracion();
    c.anadirSesion(new sesion("IS",2,3));
    test.equal(1,c.getSesiones().length);
    test.done();
}

exports.testRecuperarSesiones = function(test){
    c = new configuracion();
    c.anadirSesion(new sesion("IS",2,3));
    test.equal("IS",c.getSesiones()[0].getAsignatura());
    test.done();
}