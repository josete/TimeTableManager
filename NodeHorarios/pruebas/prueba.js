var Prolog = require('jsprolog');

var prueba = function(asignatura,horas,curso){
	
this.anadirLives = function(X,Y,datos){
	if(Object.prototype.toString.call(Y) === '[object Array]'){
		Y.forEach(function (element) {
            datos += "lives("+X+","+element+").";
        }, this);
	}else{
		datos += "lives("+X+","+Y+").";
	}
	return [Prolog.default.Parser.parse(datos),datos];
}

this.anadirBird = function(X,datos){
	if(Object.prototype.toString.call(X) === '[object Array]'){
		X.forEach(function (element) {
            datos += "bird("+element+").";
        }, this);
	}else{
		datos += "bird("+X+").";
	}
	return [Prolog.default.Parser.parse(datos),datos];
}

}
module.exports = prueba;