# Generated by Django 4.1 on 2022-08-08 01:04

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('administracionHospital', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='paciente',
            name='medico_m',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='paciente_list', to='administracionHospital.medico'),
        ),
    ]
