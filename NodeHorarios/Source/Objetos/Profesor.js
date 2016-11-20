var Profesor = function (nombre, minHorasDia, maxHorasDia) {
	if (nombre == null) {
		throw Error("Profesor sin nombre");
	}
	if (maxHorasDia == 0) {
		throw Error("Profesor sin horas");
	}
	this.nombre = nombre;
	this.diasConClase = {};
	this.minHorasDia = minHorasDia;
	this.maxHorasDia = maxHorasDia;
	this.horasDiaActual = 0;

	this.getNombre = function () {
		return this.nombre;
	}

	this.anadirClase = function (key, sesion) {
		this.diasConClase[key] = sesion.getAsignatura();
		this.horasDiaActual += sesion.getHoras();
	}

	this.getClases = function () {
		return this.diasConClase;
	}

}

module.exports = Profesor;