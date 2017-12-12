package nicolas.quillon.iem.gestion_comics.ui.Vue;

import android.content.Context;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comic;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comics;
import nicolas.quillon.iem.gestion_comics.R;

public class ListAdapterComics extends ArrayAdapter<Comic> {

    Context context;
    //region Constructeur

    public ListAdapterComics(Context pContext, List objects){
        super(pContext, 0, objects);
        context = pContext;
    }

    //endregion


    //region Override
    @Override
    public View getView(int pPosition, View pConvertView, ViewGroup pParent){
        if(pConvertView == null){
            pConvertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_adapter_comics,pParent, false);
        }

        ViewHolder viewHolder  = (ViewHolder) pConvertView.getTag();

        if (viewHolder == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            pConvertView = inflater.inflate(R.layout.activity_list_adapter_comics, pParent, false);

            viewHolder.imageViewComic = (ImageView) pConvertView.findViewById(R.id.imageViewComic);
            viewHolder.textViewTitle = (TextView) pConvertView.findViewById(R.id.textViewTitre);
            viewHolder.textViewDate = (TextView) pConvertView.findViewById(R.id.textViewDate);
            viewHolder.textViewNumbersPages = (TextView) pConvertView.findViewById(R.id.textViewNbPage);

            pConvertView.setTag(viewHolder);

        }

        Comic comic = getItem(pPosition);
        viewHolder.textViewTitle.setText(comic.getTitle());
        viewHolder.textViewDate.setText(comic.getDate());
        viewHolder.textViewNumbersPages.setText(""+comic.getPageCount());

        Picasso.with(context).load(comic.getImage()).resize(100, 150).into(viewHolder.imageViewComic);

        return pConvertView;

    }

    //endregion



    private static class ViewHolder{
        ImageView imageViewComic;
        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewNumbersPages;
    }
}



