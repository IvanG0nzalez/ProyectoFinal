from django.db import models


class Hospital(models.Model):
    nombre = models.CharField(max_length=30, blank=False)
    num_especialistas = models.PositiveIntegerField(null=False, default=0, editable=False)

    @property
    def sueldos_medicos(self):
        total = 0
        aux = self.medico_list.all()
        for medico in aux:
            total = medico.sueldo + total
        return total

    @property
    def sueldos_medicos_anual(self):
        total = 0
        aux = self.medico_list.all()
        for medico in aux:
            total = medico.sueldo + total
        return total*12

    @property
    def sueldos_enfermeros(self):
        total = 0
        aux = self.enfermero_list.all()
        for enfermero in aux:
            total = enfermero.sueldo + total
        return total

    @property
    def sueldos_enfermeros_anual(self):
        total = 0
        aux = self.enfermero_list.all()
        for enfermero in aux:
            total = enfermero.sueldo + total
        return total * 12

    @property
    def total(self):
        total = self.sueldos_medicos + self.sueldos_enfermeros
        return total

    @property
    def totalAnual(self):
        total = (self.sueldos_medicos + self.sueldos_enfermeros)*12
        return total

    @property
    def especialistas(self):
        aux = self.medico_list.all()
        for total in aux:
            total = self.num_especialistas + 1
            self.num_especialistas = total
        return self.num_especialistas

    def __str__(self):
        return self.nombre


class Ubicacion(models.Model):
    provincia = models.CharField(max_length=30, blank=False)
    ciudad = models.CharField(max_length=30, blank=False)
    calle_principal = models.CharField(max_length=30, blank=False)
    hospital = models.OneToOneField('Hospital', on_delete=models.CASCADE, null=False, blank=False)

    def __str__(self):
        return self.calle_principal


class Persona(models.Model):
    nombre = models.CharField(max_length=25, blank=False, null=True)
    apellido = models.CharField(max_length=25, blank=False, null=True)
    cedula = models.CharField(max_length=10, blank=False, null=True)


class Medico(Persona):
    especialidad = models.CharField(max_length=30, blank=False)
    sueldo = models.FloatField()
    num_consultorio = models.CharField(max_length=3, blank=False)
    hospital = models.ForeignKey('Hospital', on_delete=models.CASCADE, related_name='medico_list')

    def __str__(self):
        return self.nombre + ' ' + self.apellido


class Enfermero(Persona):
    sueldo = models.FloatField()
    tipo_contrato = models.CharField(max_length=40, blank=False)
    hospital = models.ForeignKey('Hospital', on_delete=models.CASCADE, related_name='enfermero_list')

    def __str__(self):
        return self.nombre + ' ' + self.apellido


class Paciente(Persona):
    edad = models.PositiveIntegerField()
    peso = models.FloatField()
    estatura = models.FloatField()
    fecha_ingreso = models.DateField('Fecha', blank=False, null=False)
    genero = models.CharField(max_length=15, blank=False)
    hospital = models.ForeignKey('Hospital', on_delete=models.CASCADE, related_name='paciente_list')
    medico_asignado = models.ForeignKey('Medico', on_delete=models.CASCADE, null=True, related_name='paciente_list')
    enfermero_asignado = models.ForeignKey('Enfermero', on_delete=models.CASCADE, null=True,
                                           related_name='paciente_list')
    motivo = models.TextField(blank=False)

    def __str__(self):
        return self.nombre + ' ' + self.apellido
