var Grupo = function(nombre,curso){
	if(nombre==null){
		throw Error("Grupo sin nombre");
	}
	this.nombre = nombre;
	this.curso = curso;
	
	this.getNombre = function(){
		return this.nombre;
	}
	this.getCurso = function(){
		return this.curso;
	}

}

module.exports = Grupo;