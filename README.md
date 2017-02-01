# SendObjectByIntent
<h3>How to pass custom data model, one activity to another Activity?</h3>
<h4>In this project I show how to pass custom data model, one activity to activity by using Intent</h4>

<b><u>Steps:</u></b>
<p>
import java.io.Serializable;
in your custom data model and implement Serializable interface, like

public class PersonData implements Serializable {
 ...
}

</p>

<p>
I show example to pass your custom data model by intent, one activity to another activity
<i>MainActivity.java</i>
<br/>
public class MainActivity extends AppCompatActivity {
 ... ... ...
 
  public static final String INTENT_OBJECT_KEY = "CustomObjectKey";
    private EditText txtName, txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainButton = (Button) findViewById(R.id.btnSendObj);
        txtName = (EditText) findViewById(R.id.edtTxtName);
        txtID = (EditText) findViewById(R.id.edtTxtID);

        //set click listener
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get user name and id
                String name = txtName.getText().toString().trim();
                String id = txtID.getText().toString().trim();

                //Initialize new person object
                final PersonData dataObj = new PersonData(name, id);
                sendObjectOtherActivity(dataObj);
            }
        });
    }

    /*User define method*/
    private void sendObjectOtherActivity(PersonData dataObj) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(INTENT_OBJECT_KEY, dataObj);
        startActivity(intent);
    }
 
 ... ... ...
 }
 <br>
</p>

<p>
<i>SecondActivity.java</i>
<br/>

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtVw = (TextView) findViewById(R.id.txtVw);

        //get intent object
        PersonData dene = (PersonData) getIntent().getSerializableExtra(MainActivity.INTENT_OBJECT_KEY);

        if (dene != null) {
            txtVw.setText("Name: " + dene.getName() + ", ID: " + dene.getId());
        } else {
            txtVw.setText("Is null");
        }
    }
}

<br/>

</p>

<p>
<i>SecondActivity.java</i>
<br/>
import java.io.Serializable;

public class PersonData implements Serializable {


    private String name;
    private String id;

    public PersonData(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
<br/>
</p>



