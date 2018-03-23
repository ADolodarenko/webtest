package app.model;

public class ModelFactory
{
	public static Model getModel(ModelType modelType)
	{
		if (modelType == ModelType.DB)
			return DBModel.getInstance();
		
		return LocalModel.getInstance();
	}
}
