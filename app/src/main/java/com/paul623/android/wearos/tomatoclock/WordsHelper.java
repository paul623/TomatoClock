package com.paul623.android.wearos.tomatoclock;


import java.util.Random;

/**
 * Created by Android Studio.
 * User: paul623
 * Date: 2021/1/31
 * Time: 22:39
 * Email:zhubaoluo@outlook.com
 */
public class WordsHelper {
    private static String time_words[]={"早上好","上午好","中午好","下午好","晚上好","夜深了，早点休息"};
    private static String default_words[]={"忍耐啊，忍耐啊，然后天就会慢慢地亮了","彼岸花花开彼岸，断肠草草断肝肠。","不管什么时候，能够改变世界的人都是一心追逐梦想的人","因为痛苦太有价值，因为回忆太珍贵，所以我们更要继续往前走。",
    "不要轻易的口出狂言，那样只会透露出你的软弱。","长风破浪会有时，直挂云帆济沧海。","曾经沧海难为水，除却巫山不是云。","爱你所爱，行你所行，听从你心，无问西东。","要保持希望在每天清晨太阳升起","事物的发展是前进性与曲折性的统一","历史的发展是不以人的意志为转移的。",
    "幸运的人一生都在被童年治愈，不幸的人一生都在治愈童年。","我们在努力扩大自己，以靠近，以触及我们自身以外的世界。","生死去留，棚头傀儡。一线断时，落落磊磊。","你说过，人最大的敌人是自己。",
            "总会有难熬的日子，但你会感谢今日努力拼命的自己","生活是自己的，你选择怎样的生活，就会成就怎样的你。"
            ,"无需自作悲悯，更无须刻意讨好，你需要的是自我丰盈与精彩",
            "不开口，没有人知道你想要什么；不去做，任何想法都只在脑海里游泳","一件事无论太晚或者太早，都不会阻拦你成为你想成为的那个人",
            "人终归要靠自己坚强起来","如果你不够优秀，人脉是不值钱的，它不是追求来的，而是吸引来的",
            "在事情没有成功之前，不要在人前谈及任何有关的计划和想法","在你还没赚到足够令自己安心的钱之前，请多点努力少点矫情",
            "每一个清晨，记得鼓励自己。没有奇迹，只有你努力的轨迹","无论你今天要面对什么，既然走到了这一步，就坚持下去",
            "每一个你所期待的美好未来，都必须依靠一个努力的踏实现在","人生的路要靠自己行走，成功要靠自己去争取。天助自助者，成功者自救",
            "你不能是一只橙子，把自己榨干了汁就被人扔掉。你该是一棵果树，春华秋实，年年繁茂","一个人的时候多一点努力，才能让自己的爱情少一点条件，多一点纯粹","听我的，一定要好好生活",
            "选择了方向与路途时，就不要抱怨，一个人只有承担起旅途风雨，才能最终守得住彩虹满天",
            "你不要感到失望，生命中遇见着的跌宕起伏，荡气回肠，都是为了最美的平凡","刻提醒自己：不要因大多数都那么认为就觉得那便是正确的",
            "不管发生什么事，都请安静且愉快地接受人生，永远地微笑着。"};
    private static final String[] morning_words={"快点开启活力满满的新一天吧！","今天也要加油！早安","要保持一天的好心情哦","为了美好的未来继续奋斗","别忘记吃早餐哦~"};
    private static final String[] am_words={"上午好，高效专注！","冲冲冲！","喝一杯咖啡，活力一整天~","有没有期待过更美好的明天呢？"};
    private static final String[] noon_words={"中午吃点好的！","中午要多吃点哦~","吃完休息一会吧","今天吃了啥"};
    private static final String[] afternoon_words={"下午的美好时光也要保持高效率哦","也可以出去走一走","坚持就是胜利呀","冲冲冲！","继续加油"};
    private static final String[] evening_words={"有没有想过，梦想实现的那一天","相信自己，你一定可以的","夜深了,也要早点休息哦~","别太矫情，你是最胖的！！！","要保持前进的动力！"};
    /**
     * 根据时间段获取问候语
     * */
    public static String getWordsByTime(){
        int timepart= DateHelper.getCurTimePart();
        Random random=new Random();
        if(random.nextInt(2)==0){
            if(timepart==0){
                return morning_words[random.nextInt(morning_words.length)];
            }else if(timepart==1){
                return am_words[random.nextInt(am_words.length)];
            }else if(timepart==2){
                return noon_words[random.nextInt(noon_words.length)];
            }else if(timepart==3){
                return afternoon_words[random.nextInt(afternoon_words.length)];
            }else{
                return evening_words[random.nextInt(evening_words.length)];
            }
        }else {
            return default_words[random.nextInt(default_words.length)];
        }

    }
    public static String getTitleWordsByTime(){
        return time_words[DateHelper.getCurTimePart()];
    }

}
