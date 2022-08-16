from django.contrib import admin

from administracionHospital.models import Hospital, Ubicacion, Medico, Enfermero, Paciente


class MedicoAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'especialidad', 'hospital')
    search_fields = ('cedula',)
    list_filter = ('hospital',)


class EnfermeroAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'tipo_contrato', 'hospital')
    search_fields = ('cedula',)
    list_filter = ('hospital',)


class PacienteAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'genero', 'motivo', 'hospital', 'medico_asignado', 'enfermero_asignado')
    search_fields = ('cedula',)
    list_filter = ('hospital', 'medico_asignado')


class HospitalAdmin(admin.ModelAdmin):
    list_display = ('nombre', 'especialistas', 'sueldos_medicos', 'sueldos_medicos_anual', 'sueldos_enfermeros',
                    'sueldos_enfermeros_anual', 'total', 'totalAnual')
    search_fields = ('nombre',)


class UbicacionAdmin(admin.ModelAdmin):
    list_display = ('provincia', 'ciudad', 'calle_principal', 'hospital')
    search_fields = ('ciudad',)
    list_filter = ('ciudad',)


admin.site.register(Hospital, HospitalAdmin)
admin.site.register(Ubicacion, UbicacionAdmin)
admin.site.register(Medico, MedicoAdmin)
admin.site.register(Enfermero, EnfermeroAdmin)
admin.site.register(Paciente, PacienteAdmin)
