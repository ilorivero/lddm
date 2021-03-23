package br.pucminas.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MeuViewHolder> {

    public static RecyclerInterface recyclerInterface;
    Context context;
    private List<Contatos> minhaLista;


    public MeuAdapter(Context ctx, List<Contatos> list, RecyclerInterface clickRecyclerInterface) {
        this.context = ctx;
        this.minhaLista = list;
        this.recyclerInterface = clickRecyclerInterface;
    }

    @Override
    public void onBindViewHolder(MeuViewHolder viewHolder, final int i) {

        Contatos contato = minhaLista.get(i);
        viewHolder.txtNome.setText(i + ":" + contato.getNome());
        viewHolder.txtTelefone.setText(contato.getTelefone());
        viewHolder.txtEmail.setText(contato.getEmail());
        viewHolder.btnDeleta.setOnClickListener((new View.OnClickListener() {
            public void onClick(View v) {
                Contatos contatoDeletado = minhaLista.get(i);
                minhaLista.remove(contatoDeletado);
                notifyItemRemoved(i);
                notifyDataSetChanged();
            }
        }));
    }


    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listacontatos, viewGroup, false);
        return new MeuViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return minhaLista.size();

    }


    protected class MeuViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtNome;
        protected TextView txtTelefone;
        protected TextView txtEmail;
        protected ImageButton btnDeleta;

        public MeuViewHolder(final View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtTelefone = itemView.findViewById(R.id.txtTelefone);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            btnDeleta = itemView.findViewById(R.id.btnDelete);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerInterface.onItemClick(minhaLista.get(getLayoutPosition()));
                }
            });
        }
    }
}
