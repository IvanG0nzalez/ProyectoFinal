# Generated by Django 4.1 on 2022-08-09 23:08

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('administracionHospital', '0016_hospital_total_sueldos'),
    ]

    operations = [
        migrations.AlterField(
            model_name='hospital',
            name='total_sueldos',
            field=models.FloatField(),
        ),
    ]
