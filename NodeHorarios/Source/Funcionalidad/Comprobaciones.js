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
		puede = true;
		if (profesor.horasDias[dia] == undefined || profesor.maxHorasDia == undefined) {
			return true;
		} else {
			if (profesor.horasDias[dia] < profesor.maxHorasDia) {
				if (profesor.horasDias[dia] + sesion.getHoras() > profesor.maxHorasDia) {
					puede = false;
				}
			} else {
				puede = false;
			}
		}
		return puede;
	}


	this.valorar = function (horario) {
		//Valoracion del solape 10 si no hay solape y 0 si hay solape
		var a = [];
		var self = this;
		Object.keys(horario.horarioGenerado).forEach(function (element) {
			try {
				var final = element.split("-")[0] + "-" + (parseInt("10", element.split("-")[1]) + parseInt("10", horario.horarioGenerado[element].horas));
				a.push(self.comprobarSolape(horario.horarioGenerado[element].getAsignatura().getProfesor(), element, final));
			} catch (err) { }
		});
		horario.valor = Math.min.apply(Math, a);
	}
}

module.exports = Comprobaciones;