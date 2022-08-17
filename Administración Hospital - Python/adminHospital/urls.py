from django.contrib import admin
from django.urls import path, include

from administracionHospital import views

urlpatterns = [
    path('', views.login_request, name='entrar'),
    path('admin/', admin.site.urls),
    path('inicio/', include('administracionHospital.urls')),
]
