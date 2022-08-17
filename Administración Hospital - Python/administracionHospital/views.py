import json

import requests
from django.contrib import messages
from django.contrib.auth.forms import AuthenticationForm, UserCreationForm
from django.shortcuts import render, get_object_or_404, redirect
from django.contrib.auth import logout, authenticate, login

from administracionHospital.forms import HospitalForm, MedicoForm, EnfermeroForm, PacienteForm, UbicacionForm
from administracionHospital.models import Hospital, Medico, Enfermero, Paciente, Ubicacion


def index(request):
    return render(request, 'adminHospital/inicio.html', {})


def hospital(request):
    hospitales = Hospital.objects.all()
    context = {
        'hospitales': hospitales,
    }
    return render(request, 'adminHospital/hospitales.html', context)


def hospital_info(request, hospital_id):
    hospital = get_object_or_404(Hospital, pk=hospital_id)
    context = {
        'hospital': hospital,
    }
    return render(request, 'adminHospital/info-hospital.html', context)


def agregar_hospital(request):
    data = {
        'form': HospitalForm()
    }
    if request.method == 'POST':
        formulario = HospitalForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:hospital')
        else:
            data["form"] = formulario
    return render(request, 'adminHospital/agregar-hospital.html', data)


def modificar_hospital(request, id):
    hospital = get_object_or_404(Hospital, id=id)
    data = {
        'form': HospitalForm(instance=hospital)
    }
    if request.method == 'POST':
        formulario = HospitalForm(data=request.POST, instance=hospital)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:hospital')
        data["form"] = formulario
    return render(request, 'adminHospital/modificar-hospital.html', data)


def eliminar_hospital(request, id):
    hospital = get_object_or_404(Hospital, id=id)
    hospital.delete()
    return redirect('adminHospital:hospital')


def medico(request):
    medicos = Medico.objects.all()
    context = {
        'medicos': medicos,
    }
    return render(request, 'adminHospital/medicos.html', context)


def medico_info(request, medico_id):
    medico = get_object_or_404(Medico, pk=medico_id)
    context = {
        'medico': medico,
    }
    return render(request, 'adminHospital/info-medico.html', context)


def agregar_medico(request):
    data = {
        'form': MedicoForm()
    }
    if request.method == 'POST':
        formulario = MedicoForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:medico')
        else:
            data["form"] = formulario
    return render(request, 'adminHospital/agregar-medico.html', data)


def modificar_medico(request, id):
    medico = get_object_or_404(Medico, id=id)
    data = {
        'form': MedicoForm(instance=medico)
    }
    if request.method == 'POST':
        formulario = MedicoForm(data=request.POST, instance=medico)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:medico')
        data["form"] = formulario
    return render(request, 'adminHospital/modificar-medico.html', data)


def eliminar_medico(request, id):
    medico = get_object_or_404(Medico, id=id)
    medico.delete()
    return redirect('adminHospital:medico')


def enfermero(request):
    enfermeros = Enfermero.objects.all()
    context = {
        'enfermeros': enfermeros,
    }
    return render(request, 'adminHospital/enfermeros.html', context)


def enfermero_info(request, enfermero_id):
    enfermero = get_object_or_404(Enfermero, pk=enfermero_id)
    context = {
        'enfermero': enfermero,
    }
    return render(request, 'adminHospital/info-enfermero.html', context)


def agregar_enfermero(request):
    data = {
        'form': EnfermeroForm()
    }
    if request.method == 'POST':
        formulario = EnfermeroForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:enfermero')
        else:
            data["form"] = formulario
    return render(request, 'adminHospital/agregar-enfermero.html', data)


def modificar_enfermero(request, id):
    enfermero = get_object_or_404(Enfermero, id=id)
    data = {
        'form': EnfermeroForm(instance=enfermero)
    }
    if request.method == 'POST':
        formulario = EnfermeroForm(data=request.POST, instance=enfermero)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:enfermero')
        data["form"] = formulario
    return render(request, 'adminHospital/modificar-enfermero.html', data)


def eliminar_enfermero(request, id):
    enfermero = get_object_or_404(Enfermero, id=id)
    enfermero.delete()
    return redirect('adminHospital:enfermero')


def paciente(request):
    pacientes = Paciente.objects.all()
    context = {
        'pacientes': pacientes,
    }
    return render(request, 'adminHospital/pacientes.html', context)


def paciente_info(request, paciente_id):
    paciente = get_object_or_404(Paciente, pk=paciente_id)
    context = {
        'paciente': paciente,
    }
    return render(request, 'adminHospital/info-paciente.html', context)


def agregar_paciente(request):
    data = {
        'form': PacienteForm()
    }
    if request.method == 'POST':
        formulario = PacienteForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:paciente')
        else:
            data["form"] = formulario
    return render(request, 'adminHospital/agregar-paciente.html', data)


def modificar_paciente(request, id):
    paciente = get_object_or_404(Paciente, id=id)
    data = {
        'form': PacienteForm(instance=paciente)
    }
    if request.method == 'POST':
        formulario = PacienteForm(data=request.POST, instance=paciente)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:paciente')
        data["form"] = formulario
    return render(request, 'adminHospital/modificar-paciente.html', data)


def eliminar_paciente(request, id):
    paciente = get_object_or_404(Paciente, id=id)
    paciente.delete()
    return redirect('adminHospital:paciente')


def ubicacion(request):
    ubicaciones = Ubicacion.objects.all()
    context = {
        'ubicaciones': ubicaciones,
    }
    return render(request, 'adminHospital/ubicaciones.html', context)


def agregar_ubicacion(request):
    data = {
        'form': UbicacionForm()
    }
    if request.method == 'POST':
        formulario = UbicacionForm(data=request.POST)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:ubicacion')
        else:
            data["form"] = formulario
    return render(request, 'adminHospital/agregar-ubicacion.html', data)


def modificar_ubicacion(request, id):
    ubicacion = get_object_or_404(Ubicacion, id=id)
    data = {
        'form': UbicacionForm(instance=ubicacion)
    }
    if request.method == 'POST':
        formulario = UbicacionForm(data=request.POST, instance=ubicacion)
        if formulario.is_valid():
            formulario.save()
            return redirect('adminHospital:ubicacion')
        data["form"] = formulario
    return render(request, 'adminHospital/modificar-ubicacion.html', data)


def eliminar_ubicacion(request, id):
    ubicacion = get_object_or_404(Ubicacion, id=id)
    ubicacion.delete()
    return redirect('adminHospital:ubicacion')


def registrarse(request):

    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            usuario = form.save()
            login(request, usuario)
            return redirect('adminHospital:index')
    form = UserCreationForm
    return render(request, 'adminHospital/registrarse.html', {"form": form})


def logout_request(request):
    logout(request)
    messages.info(request, "Sesión cerrada exitosamente")
    return redirect('adminHospital:entrar')


def login_request(request):

    if request.method == "POST":
        form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            usuario = form.cleaned_data.get('username')
            contrasenia = form.cleaned_data.get('password')
            user = authenticate(username=usuario, password=contrasenia)

            if user is not None:
                login(request, user)
                return redirect('adminHospital:index')
            else:
                for msg in form.error_messages:
                    messages.error(request, f"{msg}: {form.error_messages[msg]}")
        else:
            messages.error(request, "Usuario o contraseña incorrectos")

    form = AuthenticationForm()
    return render(request, 'adminHospital/login.html', {"form": form})


def api_marvel(request, url='https://gateway.marvel.com:443/v1/public/characters?ts=1&apikey=89768f35c76a6d489c0302a3e63c3515&hash=a6f60efb9ba95fbce087d205842af713'):
    with requests.Session() as session:
        response = session.get(url)
        response_json = json.loads(response.text)
        if response.status_code == 200:
            personajes = response_json['data']['results']
            context = {
                'characters': personajes
            }
            return render(request, 'adminHospital/api-marvel.html', context)
