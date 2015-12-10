package turkey.core.task;

import java.util.LinkedList;
import java.util.List;

public class Task {
	
	//目标节点
	private String targetDes;
	//实际发送到的节点
	private String realDes;
	//该Task 归属的Job
	private String jobId;
	//运行的jar包名称
	private String jarName;
	//主类的包名+类名
	private String mainClassName;
	//附件的参数列表
	private List<Param> params;
	//Task运行完毕的结果是否上传
	private boolean isUpload;
	
	public Task(){
		params = new LinkedList<Param>();
	}
	
	public String getTargetDes() {
		return targetDes;
	}
	
	public void setTargetDes(String targetDes) {
		this.targetDes = targetDes;
	}
	
	public String getRealDes() {
		return realDes;
	}
	
	public void setRealDes(String realDes) {
		this.realDes = realDes;
	}
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getJarName() {
		return jarName;
	}
	
	public void setJarName(String jarName) {
		this.jarName = jarName;
	}
	
	public String getMainClassName() {
		return mainClassName;
	}
	
	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}
	
	public List<Param> getParams() {
		return params;
	}
	
	public void setParams(List<Param> params) {
		this.params = params;
	}
	
	public boolean isUpload() {
		return isUpload;
	}
	
	public void setUpload(boolean isUpload) {
		this.isUpload = isUpload;
	}
	
	
}
