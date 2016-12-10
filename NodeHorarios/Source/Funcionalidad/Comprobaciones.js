var Comprobaciones = function () {

	this.comprobarSolape = function (profesor, A0, Af) {
		puede = 10;
		//El primer Horario siempre devuelve 10 porque no se puede solapar con nadie
		if (Object.keys(profesor.getClases()).length > 0) {
			if (profesor.getClases().hasOwnProperty(A0)) {
				puede = 0;
			} else {
				partes0 = A0.split("-");
				partesf = Af.split("-");
				horas = Object.keys(profesor.getClases());
				horas.forEach(function (element) {
					ps = element.split("-");
					if (p[1] > partes0[0] && p[1] < partesf[1]) {
						puede = 0;
					}
				});
			}
		}
		return puede;
	}

	this.comprobarHorasDiarias = function (profesor, sesion, dia) {
		puede = 10;
		if (profesor.horasDias[dia] == undefined || profesor.maxHorasDia == undefined) {
			return 10;
		} else {
			if (profesor.horasDias[dia] < profesor.maxHorasDia) {
				if (profesor.horasDias[dia] + sesion.getHoras() > profesor.maxHorasDia) {
					puede = 0;
				}
			} else {
				puede = 0;
			}
		}
		return puede;
	}

	this.comprobarClasesElMismoDia = function (horario, dia) {
		mismoDia = [];
		puede = 5;
		Object.keys(horario).forEach(function (element) {
			if (element.split("-")[0] == dia) {
				mismoDia.push(element);
			}
		});

		for (var i = 0; i < mismoDia.length; i++) {
			for (var j = (i+1); j < mismoDia.length; j++) {
				if (horario[mismoDia[i]].getAsignatura() == horario[mismoDia[j]].getAsignatura()) {
					return 0;
				}
			}
		}
		return puede;
	}


	this.valorar = function (horario) {
		var solapes = [];
		var maximas = [];
		var repetidas = [];
		var self = this;
		Object.keys(horario.horarioGenerado).forEach(function (element) {
			try {
				var final = element.split("-")[0] + "-" + (parseInt("10", element.split("-")[1]) + parseInt("10", horario.horarioGenerado[element].horas));
				solapes.push(self.comprobarSolape(horario.horarioGenerado[element].getAsignatura().getProfesor(), element, final));
				maximas.push(self.comprobarHorasDiarias(horario.horarioGenerado[element].getAsignatura().getProfesor(), horario.horarioGenerado[element], element));
				repetidas.push(self.comprobarClasesElMismoDia(horario.horarioGenerado, element.split("-")[0]));
			} catch (err) { }
		});
		horario.valor = (Math.min.apply(Math, solapes) + Math.min.apply(Math, maximas) + Math.min.apply(Math, repetidas));
	}
}

module.exports = Comprobaciones;