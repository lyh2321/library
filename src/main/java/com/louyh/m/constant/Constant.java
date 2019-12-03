package com.louyh.m.constant;

public class Constant {

    // 用户登录之后，存储用户的session所用的键
    public static final String USER_INFO = "userinfo";

    public static final String USER_INFO_USERID = "uuserid";
    public static final String USER_INFO_USERNAME = "uusername";
    public static final String USER_INFO_USERSEX = "uusersex";

    // 角色组的缓存键(本键的值保存的是权限组所有键的信息)
    public static final String ROLES_FUNCTIONS = "rolesrelevantfunction";
//    /**
//     * redis的 消息key
//     * <p>
//     * 结构
//     * key<String>  msg:[uuid]
//     * value<Hash<String,String>>   id,createDate,createUserinfo,conent,title,state,pNumber,dictid,dictname,status
//     */
//    public static final String MSG_ID = "msg:";
//    /**
//     * redis的 消息详情key
//     * <p>
//     * 结构
//     * key<String>  msg:detail:[uuid]
//     * value<Hash<String,String>> id,receiveUserinfo,receiveDate,msgid,status
//     */
//    public static final String MSG_DETAIL_ID = "msg:detail:";
//    /**
//     * redis的 用户消息列表key
//     * <p>
//     * 结构
//     * key<String>  msg:user:[uuid]
//     * value<List<String>>  消息详情[uuid]
//     */
//    public static final String MSG_USER_ID = "msg:user:";
//
//    /**
//     * solr中msg的core
//     */
//    public static final String SOLR_MSG = "msg";

    /**
     * 同时看课判断
     */
    public static final String P_COURSE_TIMING = "p:course:timing";
    /**
     * redis课程评分
     */
    public static final String P_COUSESCORE = "p:coursescore";

    /**
     * redis课程评分(我的)
     */
    public static final String P_ME_COUSESCORE = "p:me:coursescore";
    /**
     * redis课程评分(整个对象)
     */
    public static final String P_OBJ_COUSESCORE = "p:obj:coursescore";
    /**
     * 公告类型在dict里面的type
     */
    public static final String NOTICE_TYPE = "dictnotice";
    /**
     * 消息类型在dict里面的type
     */
    public static final String MSG_TYPE = "dictmsg";
    /**
     * 帮助类型在dict里面的type
     */
    public static final String HELP_TYPE = "dicthelp";
    /**
     * 新闻类型在dict里面的type
     */
    public static final String ARTICLE_TYPE = "dictarticle";
    /**
     * 动态类型在dict里面的type
     */
    public static final String DYNAMIC_TYPE = "dictdynamic";

    /**
     * 分中心之窗类型在dict里面的type
     */
    public static final String SUBCENTER_TYPE = "dictsubcenter";

    /**
     * 专栏文章类型在dict里面的type
     */
    public static final String COLUMN_TYPE = "column";

    /**
     * 行政级别类型在dict里面的type
     */
    public static final String ADMIN_TYPE = "administrativelevel";

    /**
     * 党派类型在dict里面的type
     */
    public static final String PARTISAN_TYPE = "partisan";

    /**
     * 学历类型在dict里面的type
     */
    public static final String EDUCATION_TYPE = "education";

    /**
     * 课程来源 在dict里面的type
     */
    public static final String COURSE_SOURCE_TYPE = "coursesource";

    /**
     * 课程年份 在dict里面的type
     */
    public static final String COURSE_YEAR_TYPE = "courseyear";

    /**
     * 用户状态类型在dict里面的type
     */
    public static final String USERINFOSTATE_TYPE = "userinfostate";

    /**
     * 考试级别在dict里面的type
     */
    public static final String EXAMLEVEL_TYPE = "examlevel";

    /**
     * 学习类型实践锻炼在dict里面的type
     */
    public static final String PRACTICE_TYPE = "practicetype";

    /**
     * 著作类型在dict里面的type
     */
    public static final String WRITETYPE_TYPE = "writetype";

    /**
     * 学习类型在dict里面的type
     */
    public static final String LEARNTYPE_TYPE = "learntype";

    /**
     * 工单类型在dict里面的type
     */
    public static final String WORK_TYPE = "worktype";

    /**
     * 默认密码在dict里面的type
     */
    public static final String DEPASSWORD_TYPE = "depassword";
    /**
     * 默认密码在dict里面的id
     */
    public static final String DEPASSWORDINFO_ID = "depasswordinfo";

    /**
     * 默认角色在dict里面的type
     */
    public static final String DEUSERROLEINFOID_TYPE = "deuserroleinfoid";
    /**
     * 默认角色在dict里面的id
     */
    public static final String DEUSERROLEINFOID_ID = "deuserroleinfoid";

    /**
     * 默认男生图片在dict里面的id
     */
    public static final String DEUSERIMAGEBOY_ID = "deuserimageboy";
    /**
     * 默认女生图片在dict里面的id
     */
    public static final String DEUSERIMAGEGIRL_ID = "deuserimagegirl";

    /**
     * 课程评论是否开启标识，在dict里面的type  （val=1 开启  val=0关闭）
     */
    public static final String COURSECOMMENTFLAG_TYPE = "coursecommentflag";
    /**
     * 论坛是否开启标识，在dict里面的type  （val=1 开启  val=0关闭）
     */
    public static final String COMMUNITYCOMMENTFLAG_TYPE = "communitycommentflag";

    /**
     * redis用户课程列表信息
     */
    public static final String P_COURSE_USERLIST_ = "p:course:userlist:";

    /**
     * redis课程信息
     */
    public static final String P_COURSE_ = "p:course:";
    /**
     * banner图
     */
    public static final String P_BANNER_LIST = "p:banner:list";

    /**
     * redis课程主表信息
     */
    public static final String P_COURSE_MAIN = "p:course:main:";

    /**
     * redis公告信息
     */
    public static final String P_NOTICE1_LIST = "p:notice1:list";
    /**
     * redis新闻信息
     */
    public static final String P_NOTICE2_LIST = "p:notice2:list";
    /**
     * redis动态信息
     */
    public static final String P_NOTICE3_LIST = "p:notice3:list";
    /**
     * redis分中心之窗信息
     */
    public static final String P_NOTICE4_LIST = "p:notice4:list";
    /**
     * redis专栏新闻信息
     */
    public static final String P_NOTICE5_LIST = "p:notice5:list";

    /**
     * redis动态信息
     */
    public static final String P_HELP_LIST = "p:help:list";
    /**
     * redis专题班详情
     */
    public static final String P_THEMATICCLASS_LIST = "p:thematicClass:list";
    /**
     * redis专题班详情
     */
    public static final String P_THEMATICCLASS_DETAIL = "p:thematicClass:detail:id";
    /**
     * redis专栏
     */
    public static final String P_SPECIALCLASS_LIST = "p:specialClass:list";
    /**
     * redis保存当前机构的所有上级机构id信息
     */
    public static final String ORGAN_PIDS = "organ:pids:";
    /**
     * redis子课程的scorm课程目录缓存
     */
    public static final String COURSE_COURSECHAPTER = "course:coursechapter:";
    /**
     * 用户课程搜索的index和type
     */
    public static final String P_ELASTICSEARCH_INDEX = "ahgb";
    public static final String P_ELASTICSEARCH_TYPE = "ahgbsearch";
    /**
     * 课程搜索的index和type
     */
    public static final String P_ELASTICSEARCH_COURSELIST_INDEX = "ahgbcourselist";
    public static final String P_ELASTICSEARCH_COURSELIST_TYPE = "ahgbsearchcourselist";
    /**
     * 补全的index和type
     */
    public static final String P_ELASTICSEARCH_COMPLETION_INDEX = "ahgbcompletionindex";
    public static final String P_ELASTICSEARCH_COMPLETION_TYPE = "ahgbcompletiontype";
    /**
     * 论坛帖子搜索的index和type
     */
    public static final String P_ELASTICSEARCH_INDEX_FORUM = "ahgbforum";
    public static final String P_ELASTICSEARCH_TYPE_FORUM = "ahgbsearchforum";
    // Elasticsearch的ik分词类型（ik_smart 或者 ik_max_word），推荐ik_max_word
    public static final String P_IK_TYPE = "ik_max_word";
    public static final String P_IK_TYPE_S = "ik_smart";
    public static final String P_IK_TYPE_COMPLETION = "ik_smart";

    /**
     * redis最新的年度学分计划
     */
    public static final String TECHINGPLAN_NEWEST = "techingplan_newest";


    /**
     * redis子课程详情
     */
    public static final String P_CHAPTER = "p:chapter";

    /**
     * 首页新闻
     */
    public static final String P_INDEX_NEWS_LIST = "p:index:news:list";

    /**
     * 首页课程
     */
    public static final String P_INDEX_COURSE_LIST = "p:index:course:list";

    /**
     * 考试剩余时间
     */
    public static final String P_EXAMTIME = "p:examtime";

    /**
     * 首页专题班
     */
    public static final String P_INDEX_THEMATICCLASS_LIST = "p:index:thematicclass:list";

    /**
     * 首页专栏
     */
    public static final String P_INDEX_SPECIALCLASS_LIST = "p:index:specialclass:list";

    /**
     * 首页友情链接
     */
    public static final String P_INDEX_SYSTEMSETUP_LIST = "p:index:systemsetuo:list";
    /**
     * 首页课程数量
     */
    public static final String P_INDEX_COURSE_NUM = "p:index:course:num";
    /**
     * 首页专题班数量
     */
    public static final String P_INDEX_THEMATICCLASS_NUM = "p:index:thematicclass:num";
    /**
     * 首页在线用户数量
     */
    public static final String P_INDEX_USERINFO_NUM = "p:index:userinfo:num";

    /**
     * 考试题目及答案
     */
    public static final String P_EXAMQUESTION_LIST = "p:examquestion:list";
    /**
     * 考试详情
     */
    public static final String P_EXAM = "p:exam:";

    /**
     * 字典缓存
     */
    public static final String P_DICT = "p:dict:";

    /**
     * 用户考试
     */
    public static final String P_EXAMUSER = "p:examuser:";
    public static final String P_EXAMUSERCOUNT = "p:examusercount";

    /**
     * 用户考试分数
     */
    public static final String EXAMUSERSCORE = "examuserscore";

    /**
     * 帖子相关业务锁的键
     */
    public static final String POSTSERVERLOCK = "postserverlock";
    /**
     * 回复相关业务锁的键
     */
    public static final String COMMENTSERVERLOCK = "commentserverlock";

    /**
     * 顶级oorgan
     */
    public static final String P_OORGAN_INDEX = "p:oorgan:index";

    /**
     * 教师的缓存
     */
    public static final String P_TEACHER_ID = "p:teacher:";
    /**
     * 论坛的一些消息类型
     */
    public static final String COM_POSTCOMMENTINFO = "postcommentinfo";          // 新的评论
    public static final String COM_COMMENTINFO = "commentinfo";                  // 新的回复
    public static final String COM_COMMENTQUOTEINFO = "commentquoteinfo";        // 新的引用
    public static final String COM_DELPOSTINFO = "delpostinfo";                  // 删除帖子
    public static final String COM_DELCOMMENTINFO = "delcommentinfo";            // 删除回复
    public static final String COM_TOP = "posttopinfo";                          // 置顶通知
    public static final String COM_GOOG = "postgoodinfo";                        // 加精通知
    public static final String COM_APPROVAL_POST_1 = "comapprovalpost1";         // 帖子审核成功通知
    public static final String COM_APPROVAL_POST_2 = "comapprovalpost2";         // 帖子审核失败通知
    public static final String COM_APPROVAL_POST_ADMIN = "comapprovalpostadmin"; // 帖子审核成功之后通知其上级管理员

    public static final String IS_JOIN_ADMINHOME = "ija";

    /**
     * 文章（notice）缓存
     */
    public static final String P_NOTICE_ID_DETAIL = "p:notice:id:detail:";
    /**
     * 文章被他人修改消息
     */
    public static final String COM_NOTICE_WARNING = "comnoticewarning";
    /**
     * 管理员之家任务创建
     */
    public static final String ADMIN_ADMINHOME_NEW_TASK = "adminadminhomenewtask";

    /**
     * 新工单
     */
    public static final String NEW_WORK = "newwork";
    /**
     * 管理员之家任务回复
     */
    public static final String ADMIN_ADMINHOME_NEW_REPLYS = "adminadminhomenewreplys";
    /**
     * mongo examuser 地址
     */
    public static final String ExamUserMongo = "examusermongo";
    public static final String P_EXAMCREATEANSWER = "p:examcreateanswer:map";

    /**
     * redis 工单类型list
     */
    public static final String P_WORKTYPE_LIST = "p:worktype:list";

    public static final String P_CREDITUSER = "p:credituser:";

    /**
     * 专题班用户列表
     */
    public static final String P_THEMATICCLASS_USER_LIST = "p:thematicClass:user:list";
    /**
     * 专题班
     */
    public static final String P_THEMATICCLASS_ID = "p:thematicClass:id:";
    public static final String P_THEMATICCLASS_COURSE = "p:thematicClass:course:";
    /**
     * 专题班同学列表
     */
    public static final String P_THEMATICCLASS_PEOPLE_NUM = "p:thematicClass:people:num";
    /**
     * pc搜索的热词记录
     */
    public static final String KEY_DYNAMIC = "p:dynamickey";
    public static final String KEY_FIXED = "p:fixedkey";

    /**
     * redis 根据课程id查询专题班;
     */
    public static final String P_COURSE_THEMATICCLASS = "p:course:thematicClass";
    /**
     * redis 根据教学计划;
     */
    public static final String P_TECHINGPLAN = "p:techingplan";
    /**
     * redis 课程排行;
     */
    public static final String P_COURSE_RANKING = "p:course:ranking:";

    /**
     * 字典type：上传课程，不需要审批的用户id
     */
    public static final String BOSS_COURSE_FLAG_INFO_TYPE = "bosscourseflaginfotype";
    /**
     * 新工单消息通知用户
     */
    public static String P_WORKMSGUSER = "p:workmsguser:";
}
