//package com.debbysa.bimbelcorner.repositories;
//
//import android.app.Application;
//import android.arch.lifecycle.LiveData;
//import android.os.AsyncTask;
//
//public class UserRepository {
//    private UserDao dao;
//
//    public UserRepository(Application application) {
//        AppDatabase db = AppDatabase.getInstance(application);
//        dao = db.userDao();
//    }
//
//    public LiveData<User> getUserByUsername(String username) {
//        return dao.getUserByUsername(username);
//    }
//
//    private static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
//        private UserDao asyncTaskDao;
//
//        @Override
//        protected Void doInBackground(User... users) {
//            asyncTaskDao.insert(users);
//            return null;
//        }
//
//        InsertAsyncTask(UserDao dao) {
//            asyncTaskDao = dao;
//        }
//    }
//
//    public void insert(User user) {
//        new InsertAsyncTask(dao).execute(user);
//    }