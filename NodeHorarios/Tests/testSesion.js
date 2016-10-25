sesion = require("../Source/Objetos/Sesion.js");

exports.testSesionCon2Horas = function(test){
    s = new sesion("IS",2,3);
    test.equal(2,s.getHoras());
    test.done();
}