var Profesor = function(nombre,minHoras,maxHoras){
	if(nombre==null){
		throw Error("Profesor sin nombre");
	}
	this.nombre = nombre;
    this.diasConClase = {};
	this.minHoras = minHoras;
	this.maxHoras = maxHoras;

	this.getNombre = function(){
		return this.nombre;
	}

    this.anadirClase = function(key,asignatura){
        this.diasConClase[key] = asignatura;
    }

	this.getClases = function(){
		return this.diasConClase;
	}

}

module.exports = Profesor;