from django.urls import path

from administracionHospital import views

app_name = 'adminHospital'

urlpatterns = [
    path('', views.index, name='index'),
    path('hospital', views.hospital, name='hospital'),
    path('hospital/<int:hospital_id>', views.hospital_info, name='hospital-id'),
    path('medico', views.medico, name='medico'),
    path('medico/<int:medico_id>', views.medico_info, name='medico_id'),
    path('enfermero', views.enfermero, name='enfermero'),
    path('enfermero/<int:enfermero_id>', views.enfermero_info, name='enfermero-id'),
    path('paciente', views.paciente, name='paciente'),
    path('paciente/<int:paciente_id>', views.paciente_info, name='paciente-id'),
    path('ubicacion', views.ubicacion, name='ubicacion'),
    path('logout/', views.logout_request, name='salir'),
    path('login/', views.login_request, name='entrar'),
    path('registrarse/', views.registrarse, name='registrarse'),
    path('agregar-hospital/', views.agregar_hospital, name='agregar_hospital'),
    path('modificar-hospital/<id>/', views.modificar_hospital, name='modificar_hospital'),
    path('eliminar-hospital/<id>/', views.eliminar_hospital, name='eliminar_hospital'),
    path('agregar-medico/', views.agregar_medico, name='agregar_medico'),
    path('modificar-medico/<id>/', views.modificar_medico, name='modificar_medico'),
    path('eliminar-medico/<id>/', views.eliminar_medico, name='eliminar_medico'),
    path('agregar-enfermero/', views.agregar_enfermero, name='agregar_enfermero'),
    path('modificar-enfermero/<id>/', views.modificar_enfermero, name='modificar_enfermero'),
    path('eliminar-enfermero/<id>/', views.eliminar_enfermero, name='eliminar_enfermero'),
    path('agregar-paciente/', views.agregar_paciente, name='agregar_paciente'),
    path('modificar-paciente/<id>/', views.modificar_paciente, name='modificar_paciente'),
    path('eliminar-paciente/<id>/', views.eliminar_paciente, name='eliminar_paciente'),
    path('agregar-ubicacion/', views.agregar_ubicacion, name='agregar_ubicacion'),
    path('modificar-ubicacion/<id>/', views.modificar_ubicacion, name='modificar_ubicacion'),
    path('eliminar-ubicacion/<id>/', views.eliminar_ubicacion, name='eliminar_ubicacion'),
    path('api-marvel/', views.api_marvel, name='api_marvel'),
]
