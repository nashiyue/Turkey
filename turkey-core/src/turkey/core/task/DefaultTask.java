package turkey.core.task;

/**
 * 默认Task类型,上传结果,不带任何参数
 * */
public class DefaultTask extends Task{
	
	public DefaultTask(String jobId,String realDes,String jarName,String mainClassName){
		this();
		this.setJobId(jobId);
		this.setRealDes(realDes);
		this.setJarName(jarName);
		this.setMainClassName(mainClassName);
	}
	
	private DefaultTask(){
		this.setParams(null);
		this.setUpload(true);
		this.setTargetDes(null);
	}
	
//	public static void main(String[] args) {
//		DefaultTask task = new DefaultTask();
//		System.out.println(task.getJarName());
//		System.out.println(task.getParams());
//	}
}
