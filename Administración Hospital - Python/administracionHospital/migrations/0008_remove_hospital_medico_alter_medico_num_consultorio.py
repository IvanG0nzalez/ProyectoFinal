# Generated by Django 4.1 on 2022-08-08 02:57

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('administracionHospital', '0007_alter_hospital_medico'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='hospital',
            name='medico',
        ),
        migrations.AlterField(
            model_name='medico',
            name='num_consultorio',
            field=models.CharField(max_length=3),
        ),
    ]
