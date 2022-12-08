package server.frameworks_and_drivers.database.data_access;

import server.frameworks_and_drivers.database.Database;
import server.usecases.rating_changes.SendRatingDsGateway;

public class RatingDataAccess implements SendRatingDsGateway
{
    Database database;

    public RatingDataAccess(Database database)
    {
        this.database = database;
    }

    @Override
    public void storeRating(int receiverUid, double avgRating, double number, double total)
    {
        String content = avgRating + "-" + number + "-" + total;
        database.updateUser(receiverUid, 3, content);
    }

    @Override
    public String userAddress(int identifier) {
        // TODO Auto-generated method stub
        return database.readUser(identifier)[7];
    }

    @Override
    public int userPort(int identifier) {
        // TODO Auto-generated method stub
        return 4444;
    }

    @Override
    public double[] getAverageRating(int userUid) {
        String[] ratingContent = database.readUser(userUid)[3].split("-");
        return new double[]{Double.parseDouble(ratingContent[1]), Double.parseDouble((ratingContent[2]))};
    }
}
    

