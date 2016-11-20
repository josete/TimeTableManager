profesor = require("../Source/Objetos/Profesor.js");
sesion = require("../Source/Objetos/Sesion.js");

exports.testNombreProfesorNotNull = function(test){
	p = new profesor("Raul");
	test.equal("Raul",p.getNombre());
	test.done();
}

exports.testProfesorinNombre = function(test){
	test.throws(function(){p = new profesor(null);});
	test.done();
}

exports.testProfesorMaxHoras0 = function(test){
    test.throws(function(){p = new profesor("Raul",0,0);});
    test.done();
}

exports.testProfesorSinHoras = function(test){
	p = new profesor("Raul",0,2);
	p.anadirClase("0-8",new sesion("sda",2,"dasd"));
	test.equal(2,p.horasDias[0]);
	test.done();
}
