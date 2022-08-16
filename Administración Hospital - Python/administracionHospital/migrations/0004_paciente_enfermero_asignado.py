# Generated by Django 4.1 on 2022-08-08 01:17

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('administracionHospital', '0003_rename_medico_m_paciente_medico_asignado'),
    ]

    operations = [
        migrations.AddField(
            model_name='paciente',
            name='enfermero_asignado',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='enfermero_list', to='administracionHospital.enfermero'),
        ),
    ]
