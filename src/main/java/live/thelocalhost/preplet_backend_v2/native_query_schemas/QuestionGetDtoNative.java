package live.thelocalhost.preplet_backend_v2.native_query_schemas;

public interface QuestionGetDtoNative {
    public Long getId();
    public String getCourseName();
    public String getSubjectName();
    public String getChapterName();
    public Integer getYear();
    public String getQuestionBody();
}
