package alnayzak.ict.ibraheem.scincehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GiftsAr extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<GiftData> mGiftsList;
    GiftData mGiftsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(GiftsAr.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mGiftsList = new ArrayList<>();
        mGiftsData = new GiftData(R.drawable.hoppers,"هوبرز", "هي لعبة تفكير ممتعة تعلم المنطق، حل المشكلات، وتقييم النتائج. تتكون من مجموعة من الضفادع على بركة يقومون بالقفز على تلك البركة حتى يتبقى اخر ضفدع .", "• المهارات: المنطق - حل المشكلات - التخطيط - التفكير التسلسلي • العمر: 5 سنوات وما فوق • نوع اللعبة: تعاونية • اللاعبون: لاعب واحد أو أكثر • المستويات: 40");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.enis,"احجية اينشتاين", "إن لغز آينشتاين هو أحد الألغاز المعقدة التي طورها الفيزيائي ألبرت آينشتاين ويعتمد على أساس التفكير المنطقي والنقدي. اللعبة تتطلب قدرا كبيرا من التركيز ، والتنظيم والتسلسل المنطقي نحو الحل. تعالج اللعبة مهارات فريق العمل وديناميكيات الفريق. نسأل أنفسنا ، هل العمل الجماعي هو أفضل طريقة لتحقيق الحلول؟ ما هي خصائص فريق جيد؟",null);
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.sciencemem,"ذاكرة العلوم", "من خلال إيجاد العلاقة بين البطاقة من خلال الصور أو النصوص ، يقوم اللاعب بتطوير الذاكرة وتحليل الشبكة بالإضافة إلى معرفة العلماء وإنجازهم الأكثر أهمية بطريقة مسلية.","• المهارات: الذاكرة والتحليل وإيجاد الصلات• الفئة العمرية: 8 سنوات فما فوق• النوع: تنافسية• عدد اللاعبين: 2 إلى 4 لاعبين");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.tquest,"تي كويست", "مع 4 قطع من الورق المقوى ، يتم تحدي اللاعب لبناء أشكال ذات معنى من خلال جمعها معًا ، وليس تغطية أي منها لإنشاء شكل من الأشكال الموجودة في قائمة الاشكال.", "• المهارات: الخيال، التحليل و التفكير خارج الصندوق• الفئة العمرية: 5 وما فوق• النوع: تعاونية• عدد اللاعبين: 2 إلى 4 لاعب• عدد المستويات: 36");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.challange,"تحدى نفسك", "تحدي نفسك هي لعبة ممتعة تضع اللاعب أمام 14 تحديًا ، مع وجود لكل بطاقة سؤال في شكل لغز. يتعين على اللاعب حل اللغز ويمكنه استخدام رموز الحل على الجانب الآخر من البطاقة. يمكن للاعب أيضا مراجعة \"العقدة\" لمعرفة لماذا لا يمكن حل هذه الألغاز باستخدام أساليب التفكير التقليدية.","• المهارات: حل المشكلات ، التحليل والروابط و التفكير خارج الصندوق\n" +
                "• الفئة العمرية : 10 سنوات فما فوق\n" +
                "• نوع اللعبة : تعاونية\n" +
                "• عدد اللاعبين : واحد\n" +
                "• عدد المستويات : 14");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.badir,"فكر...بادر","لعبة ممتعة من 14 حالة تفكير ، في كل بطاقة سوف تجد حالة تفكير في شكل اللغزعلى كل لاعب أن يفكر ، يمكنه استخدام رمز الحل على ظهر البطاقة ، كما يمكنه التحقق من \"العقدة\" لمعرفة ما يجب القيام به في كل حالة.","• المهارات: حل المشكلات ، التحليل و التفكير خارج الصندوق\n" +
                "• الفئة العمرية: 12 سنة وما فوق\n" +
                "• نوع اللعبة: تعاونية\n" +
                "• عدد اللاعبين: واحد\n" +
                "• عدد المستويات: 14");
        mGiftsList.add(mGiftsData);
        mGiftsData = new GiftData(R.drawable.rush,"Rush Hour", getString(R.string.rhd),getString(R.string.rhm));
        GiftsARAdapter myAdapter = new GiftsARAdapter(GiftsAr.this, mGiftsList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
