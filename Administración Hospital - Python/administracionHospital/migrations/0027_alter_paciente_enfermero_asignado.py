# Generated by Django 4.1 on 2022-08-13 04:45

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('administracionHospital', '0026_alter_paciente_motivo'),
    ]

    operations = [
        migrations.AlterField(
            model_name='paciente',
            name='enfermero_asignado',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='paciente_list', to='administracionHospital.enfermero'),
        ),
    ]
