package ixigo.invincible.takemethere.harsh.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Vector;

import butterknife.ButterKnife;
import ixigo.invincible.takemethere.harsh.commons.EventObject;
import ixigo.invincible.takemethere.harsh.interfaces.Constants;

//All activities in the app must extend this Activity common Task Like Event Bus and ButterKnife Initialization Done Here.
public abstract class BaseActivity extends AppCompatActivity implements Constants {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private PauseHandler pauseHandler = new PauseHandler();
    private ProgressDialog progressDialog;
    public final int SHOW_TOAST = 0;

    protected abstract
    @LayoutRes
    int getLayout();

    @Subscribe
    public abstract void onEvent(EventObject eventObject);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectViews();
        EventBus.getDefault().register(this);
        initProgressDialog(ProgressDialogsToastsText.PLEASE_WAIT);
    }

    private void initProgressDialog(String msg) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(msg);
    }

    public void showProgress(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    public void dismissProgress() {
        progressDialog.dismiss();
    }

    private void injectViews() {
        ButterKnife.bind(this);
    }

    public void sendMessageToHandler(int what, int arg1, int arg2, Object response) {
        Message message = pauseHandler.obtainMessage();
        message.obj = response;
        message.what = what;
        message.arg1 = arg1;
        message.arg2 = arg2;
        pauseHandler.sendMessage(message);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        showInternetDialog();
        pauseHandler.setBaseActivity(this);
        pauseHandler.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseHandler.pause();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        progressDialog.dismiss();
        super.onDestroy();
    }

    private class PauseHandler extends Handler {

        protected BaseActivity baseActivity;

        /**
         * Message Queue Buffer
         */
        final Vector<Message> messageQueueBuffer = new Vector<>();

        /**
         * Flag indicating the pause state
         */
        private boolean paused;

        /**
         * Resume the handler
         */
        final public void resume() {
            paused = false;

            while (messageQueueBuffer.size() > 0) {
                final Message msg = messageQueueBuffer.elementAt(0);
                messageQueueBuffer.removeElementAt(0);
                sendMessage(msg);
            }
        }

        /**
         * Pause the handler
         */
        final public void pause() {
            paused = true;
        }

        public boolean isPaused() {
            return paused;
        }

        final void setBaseActivity(BaseActivity baseActivity) {
            this.baseActivity = baseActivity;
        }

        protected boolean storeMessage(Message message) {
            return true;
        }


        @Override
        final public void handleMessage(Message msg) {
            if (paused) {
                if (storeMessage(msg)) {
                    Message msgCopy = new Message();
                    msgCopy.copyFrom(msg);
                    messageQueueBuffer.add(msgCopy);
                }
            } else {
                processMessage(msg);
            }
        }
    }

    public boolean isActivityPaused() {
        return pauseHandler.isPaused();
    }

    public void processMessage(Message message) {
        switch (message.what) {
            case SHOW_TOAST:
                String msg = (String) message.obj;
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
