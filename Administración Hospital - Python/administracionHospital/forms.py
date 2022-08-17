from django import forms

from administracionHospital.models import Hospital, Medico, Enfermero, Paciente, Ubicacion


class HospitalForm(forms.ModelForm):
    class Meta:
        model = Hospital
        fields = '__all__'


class MedicoForm(forms.ModelForm):
    class Meta:
        model = Medico
        fields = '__all__'


class EnfermeroForm(forms.ModelForm):
    class Meta:
        model = Enfermero
        fields = '__all__'


class PacienteForm(forms.ModelForm):
    class Meta:
        model = Paciente
        fields = '__all__'

        widgets = {
            "fecha_ingreso": forms.SelectDateWidget()
        }


class UbicacionForm(forms.ModelForm):
    class Meta:
        model = Ubicacion
        fields = '__all__'
