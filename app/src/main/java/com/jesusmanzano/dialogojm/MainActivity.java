package com.jesusmanzano.dialogojm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.saveButton).setOnClickListener(v -> showConfirmationDialog());

        findViewById(R.id.saveButton2).setOnClickListener(v -> showCustomDialog());
    }

    private void showConfirmationDialog() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        alertDialogBuilder.setTitle("Confirmación");
        alertDialogBuilder.setMessage("¿Estás seguro de continuar?");
        alertDialogBuilder.setPositiveButton("Sí", (dialog, id) -> {

            showToast("Seleccionaste aceptar");
        });
        alertDialogBuilder.setNegativeButton("No", (dialog, id) -> {
            dialog.cancel();
            showToast("Seleccionaste cancelar");
        });
        alertDialogBuilder.create().show();
    }
    public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main2);


            ImageView imageView = findViewById(R.id.imagen);

            imageView.setImageResource(R.drawable.tolove);
        }
    }

    private void showCustomDialog() {
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);
        alertDialogBuilder.setTitle("Mensaje Personalizado");
        alertDialogBuilder.setMessage("Introduce tu nombre:");

        final EditText input = new EditText(this);
        alertDialogBuilder.setView(input);


        alertDialogBuilder.setIcon(R.drawable.tolove);

        alertDialogBuilder.setPositiveButton("Guardar", (dialog, id) -> {
            String nombre = input.getText().toString();
            showToast("¡Hola, " + nombre + "!");
        });

        alertDialogBuilder.setNegativeButton("Cancelar", (dialog, id) -> {
            dialog.cancel();
            showToast("Seleccionaste cancelar");
        });

        alertDialogBuilder.create().show();
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

