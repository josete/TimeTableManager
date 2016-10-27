var Asignatura = function(nombre,curso,titulacion){
	if(nombre==null){
		throw Error("Asignautra sin nombre");
	}
	this.nombre = nombre;
	this.curso = curso;
	this.titulacion = titulacion;
	this.puede = true;

	this.getAsignaturaInfo = function(){
		return this.nombre + " "+this.curso+ " "+this.titulacion.nombre;
	}
	this.getNombre = function(){
		return this.nombre;
	}
	this.getCurso = function(){
		return this.curso;
	}

	this.diaActualPuede = function(){
		return this.puede;
	}
	
	this.setPuede = function(puede){
		this.puede = puede;
	}

}

module.exports = Asignatura;
