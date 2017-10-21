package my.hhx.com.chunnews.modules.channel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.CacheUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import my.hhx.com.chunnews.MessageEvent;
import my.hhx.com.chunnews.R;


public class ChannelActivity extends AppCompatActivity {


    @BindView(R.id.channel_recycler)
    RecyclerView channelRecycler;
    private String myTitle[] = new String[]{"最新", "评测室", "安卓", "手机", "数码"};
    private String otherTitle[] = new String[]{"电脑", "极客学院", "vr", "智能汽车", "游戏电竞", "windows",
            "发布会", "阳台", "苹果", "科普", "网络焦点", "行业前沿"};
    private String myTag[] = new String[]{"news", "labs", "android", "phone", "digi"};
    private String otherTag[] = new String[]{"pc", "geek", "vr", "auto", "game", "windows",
            "live", "balcony", "ios", "discovery", "internet", "it"};
    private String myNewsTitle[] = new String[]{"热点", "科技", "娱乐", "精选"};
    private String otherNewsTitle[] = new String[]{"网易独家", "体育", "游戏", "暴雪游戏", "手机", "足球", "NBA", "数码", "智能",
            "轻松一刻", "知乎日报", "健康", "商业", "教育", "古玩", "政务", "跑步", "历史", "股票", "彩票", "CBA", "中国足球", "旅游", "网易博客", "汽车", "军事"};
    private String myNewsTag[] = new String[]{"T1348647909107", "T1348649580692", "T1348648517839", "T1467284926140"};
    private String otherNewsTag[] = new String[]{"T1370583240249", "T1348649079062", "T1348654151579", "T1397016069906", "T1348649654285", "T1348649176279", "T1348649145984", "T1348649776727",
            "T1351233117091", "T1350383429665", "zhihu", "T1414389941036", "T1348648756099", "T1348654225495", "T1441074311424", "T1414142214384",
            "T1411113472760", "T1368497029546", "T1473054348939", "T1356600029035", "T1348649475931", "T1348649503389", "T1348654204705", "T1349837698345", "T1348654060988", "T1348648141035"};
    private String myJiemianTitle[] = new String[]{"新闻", "JMedia", "科技", "天下", "中国"};
    private String myJiemianTag[] = new String[]{"644", "122", "123", "118", "260"};
    private String otherJiemianTitle[] = new String[]{"商业", "热读", "汽车", "地产", "金融", "消费", "证券", "时尚",
            "工业", "数据", "美丽中国", "军事", "正午", "歪楼", "营销", "职场", "管理", "热评", "最新"
            , "体育", "娱乐", "文化", "旅行", "生活", "出国", "茶语", "游戏", "图片", "宏观", "投资", "交通", "创业", "财经"};
    private String otherJiemianTag[] = new String[]{"117", "181", "138", "121", "137", "139", "322", "183",
            "259", "495", "550", "293", "120", "119", "182", "201", "442", "124", "152"
            , "202", "203", "406", "313", "447", "469", "470", "294", "158", "519", "142", "140", "463", "643"};
    private static final int SAVE_TIME= 60*60*24*30*12*20;
    private ArrayList<ChannelEntity> allList = new ArrayList<>();
    private ArrayList<ChannelEntity> myList = new ArrayList<>();
    private ArrayList<ChannelEntity> otherList = new ArrayList<>();
    private String mTag;
    private CacheUtils cacheUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTag = getIntent().getStringExtra("type");
        initData();
        init();
    }

    private void init() {

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        channelRecycler.setLayoutManager(manager);

        final ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(channelRecycler);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, myList, otherList);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY || viewType == ChannelAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        channelRecycler.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ChannelActivity.this, myList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnCompleteListener(new ChannelAdapter.OnCompleteListener() {
            @Override
            public void onComplete(ArrayList<ChannelEntity> myChannelItems, ArrayList<ChannelEntity> otherChannelItems) {
                switch (mTag) {
                    case "it":
                        cacheUtil = CacheUtils.getInstance("channel");
                        cacheUtil.put("myChannel", myChannelItems,SAVE_TIME);
                        cacheUtil.put("otherChannel", otherChannelItems,SAVE_TIME);
                        EventBus.getDefault().post(new MessageEvent("refreshFragment"));
                        break;
                    case "news":
                        cacheUtil = CacheUtils.getInstance("channel");
                        cacheUtil.put("myNewsChannel", myChannelItems,SAVE_TIME);
                        cacheUtil.put("otherNewsChannel", otherChannelItems,SAVE_TIME);
                        EventBus.getDefault().post(new MessageEvent("refreshNews"));
                        break;
                    case "jiemian":
                        cacheUtil = CacheUtils.getInstance("channel");
                        cacheUtil.put("myJiemianChannel", myChannelItems,SAVE_TIME);
                        cacheUtil.put("otherJiemianChannel", otherChannelItems,SAVE_TIME);
                        EventBus.getDefault().post(new MessageEvent("refreshJiemian"));
                        break;
                    default:
                        break;
                }

            }
        });

    }


    private void initData() {
        cacheUtil = CacheUtils.getInstance("channel");
        switch (mTag) {
            case "it":
                for (int i = 0; i < myTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(myTitle[i]);
                    channelEntity.setTag(myTag[i]);
                    allList.add(channelEntity);
                }
                for (int i = 0; i < otherTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(otherTitle[i]);
                    channelEntity.setTag(otherTag[i]);
                    allList.add(channelEntity);
                }
                if (cacheUtil.getSerializable("myChannel") == null) {

                    for (int i = 0; i < myTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(myTitle[i]);
                        channelEntity.setTag(myTag[i]);
                        myList.add(channelEntity);
                    }
                    for (int i = 0; i < otherTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(otherTitle[i]);
                        channelEntity.setTag(otherTag[i]);
                        otherList.add(channelEntity);
                    }
                } else {
                    if (myList != null && otherList != null) {
                        myList.clear();
                        otherList.clear();
                        myList.addAll((ArrayList<ChannelEntity>) cacheUtil.getSerializable("myChannel"));
                        allList.removeAll(myList);
                        otherList.addAll(allList);

                    }
                }
                break;
            case "news":
                for (int i = 0; i < myNewsTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(myNewsTitle[i]);
                    channelEntity.setTag(myNewsTag[i]);
                    allList.add(channelEntity);
                }
                for (int i = 0; i < otherNewsTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(otherNewsTitle[i]);
                    channelEntity.setTag(otherNewsTag[i]);
                    allList.add(channelEntity);
                }

                if (cacheUtil.getSerializable("myNewsChannel") == null) {

                    for (int i = 0; i < myNewsTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(myNewsTitle[i]);
                        channelEntity.setTag(myNewsTag[i]);
                        myList.add(channelEntity);
                    }
                    for (int i = 0; i < otherNewsTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(otherNewsTitle[i]);
                        channelEntity.setTag(otherNewsTag[i]);
                        otherList.add(channelEntity);
                    }
                } else {
                    if (myList != null && otherList != null) {
                        myList.clear();
                        otherList.clear();
                        myList.addAll((ArrayList<ChannelEntity>) cacheUtil.getSerializable("myNewsChannel"));
                        Log.e("array", myList.toString());
                        allList.removeAll(myList);
                        Log.e("array", allList.toString());
                        otherList.addAll(allList);
                        Log.e("array", otherList.toString());


                    }
                }
                break;
            case "jiemian":
                for (int i = 0; i < myJiemianTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(myJiemianTitle[i]);
                    channelEntity.setTag(myJiemianTag[i]);
                    allList.add(channelEntity);
                }
                for (int i = 0; i < otherJiemianTitle.length; i++) {
                    ChannelEntity channelEntity = new ChannelEntity();
                    channelEntity.setName(otherJiemianTitle[i]);
                    channelEntity.setTag(otherJiemianTag[i]);
                    allList.add(channelEntity);
                }

                if (cacheUtil.getSerializable("myJiemianChannel") == null) {

                    for (int i = 0; i < myJiemianTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(myJiemianTitle[i]);
                        channelEntity.setTag(myJiemianTag[i]);
                        myList.add(channelEntity);
                    }
                    for (int i = 0; i < otherJiemianTitle.length; i++) {
                        ChannelEntity channelEntity = new ChannelEntity();
                        channelEntity.setName(otherJiemianTitle[i]);
                        channelEntity.setTag(otherJiemianTag[i]);
                        otherList.add(channelEntity);
                    }
                } else {
                    if (myList != null && otherList != null) {
                        myList.clear();
                        otherList.clear();
                        myList.addAll((ArrayList<ChannelEntity>) cacheUtil.getSerializable("myJiemianChannel"));
                        Log.e("array", myList.toString());
                        allList.removeAll(myList);
                        Log.e("array", allList.toString());
                        otherList.addAll(allList);
                        Log.e("array", otherList.toString());

                    }
                }
                break;
            default:
                break;
        }


    }

    private void upDataCache() {

    }


}
