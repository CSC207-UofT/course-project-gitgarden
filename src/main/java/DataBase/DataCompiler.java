package DataBase;

public class DataCompiler {
    /*
    /**
     * A strategy (or policy) definition that is used to decide whether or not a field or top-level
     * class should be serialized or deserialized as part of the JSON output/input. For serialization,
     * if the {@link #shouldSkipClass(Class)} method returns true then that class or field type
     * will not be part of the JSON output. For deserialization, if {@link #shouldSkipClass(Class)}
     * returns true, then it will not be set as part of the Java object structure.
     *
     * <p>The following are a few examples that shows how you can use this exclusion mechanism.
     *
     * <p><strong>Exclude fields and objects based on a particular class type:</strong>
     * <pre class="code">
     * private static class SpecificClassExclusionStrategy implements ExclusionStrategy {
     *   private final Class&lt;?&gt; excludedThisClass;
     *
     *   public SpecificClassExclusionStrategy(Class&lt;?&gt; excludedThisClass) {
     *     this.excludedThisClass = excludedThisClass;
     *   }
     *
     *   public boolean shouldSkipClass(Class&lt;?&gt; clazz) {
     *     return excludedThisClass.equals(clazz);
     *   }
     *
     *   public boolean shouldSkipField(FieldAttributes f) {
     *     return excludedThisClass.equals(f.getDeclaredClass());
     *   }
     * }
     * </pre>
     *
     * <p><strong>Excludes fields and objects based on a particular annotation:</strong>
     * <pre class="code">
     * public &#64;interface FooAnnotation {
     *   // some implementation here
     * }
     *
     * // Excludes any field (or class) that is tagged with an "&#64;FooAnnotation"
     * private static class FooAnnotationExclusionStrategy implements ExclusionStrategy {
     *   public boolean shouldSkipClass(Class&lt;?&gt; clazz) {
     *     return clazz.getAnnotation(FooAnnotation.class) != null;
     *   }
     *
     *   public boolean shouldSkipField(FieldAttributes f) {
     *     return f.getAnnotation(FooAnnotation.class) != null;
     *   }
     * }
     * </pre>
     *
     * <p>Now if you want to configure {@code Gson} to use a user defined exclusion strategy, then
     * the {@code GsonBuilder} is required. The following is an example of how you can use the
     * {@code GsonBuilder} to configure Gson to use one of the above sample:
     * <pre class="code">
     * ExclusionStrategy excludeStrings = new UserDefinedExclusionStrategy(String.class);
     * Gson gson = new GsonBuilder()
     *     .setExclusionStrategies(excludeStrings)
     *     .create();
     * </pre>
     *
     * <p>For certain model classes, you may only want to serialize a field, but exclude it for
     * deserialization. To do that, you can write an {@code ExclusionStrategy} as per normal;
     * however, you would register it with the
     * {@link GsonBuilder#addDeserializationExclusionStrategy(ExclusionStrategy)} method.
     * For example:
     * <pre class="code">
     * ExclusionStrategy excludeStrings = new UserDefinedExclusionStrategy(String.class);
     * Gson gson = new GsonBuilder()
     *     .addDeserializationExclusionStrategy(excludeStrings)
     *     .create();
     * </pre>
     *
     * @author Inderjeet Singh
     * @author Joel Leitch
     *
     * @see GsonBuilder#setExclusionStrategies(ExclusionStrategy...)
     * @see GsonBuilder#addDeserializationExclusionStrategy(ExclusionStrategy)
     * @see GsonBuilder#addSerializationExclusionStrategy(ExclusionStrategy)
     *
     * @since 1.4
     */
    public interface ExclusionStrategy {

        /**
         * @param f the field object that is under test
         * @return true if the field should be ignored; otherwise false
         */
        //public boolean shouldSkipField(FieldAttributes f);

        /**
         * @param clazz the class object that is under test
         * @return true if the class should be ignored; otherwise false
         */
        public boolean shouldSkipClass(Class<?> clazz);
    }
    /*
         public Gson() {
    this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY,
        Collections.<Type, InstanceCreator<?>>emptyMap(), DEFAULT_SERIALIZE_NULLS,
        DEFAULT_COMPLEX_MAP_KEYS, DEFAULT_JSON_NON_EXECUTABLE, DEFAULT_ESCAPE_HTML,
        DEFAULT_PRETTY_PRINT, DEFAULT_LENIENT, DEFAULT_SPECIALIZE_FLOAT_VALUES,
        LongSerializationPolicy.DEFAULT, null, DateFormat.DEFAULT, DateFormat.DEFAULT,
        Collections.<TypeAdapterFactory>emptyList(), Collections.<TypeAdapterFactory>emptyList(),
        Collections.<TypeAdapterFactory>emptyList(), ToNumberPolicy.DOUBLE, ToNumberPolicy.LAZILY_PARSED_NUMBER);
  }

  Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy,
      Map<Type, InstanceCreator<?>> instanceCreators, boolean serializeNulls,
      boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe,
      boolean prettyPrinting, boolean lenient, boolean serializeSpecialFloatingPointValues,
      LongSerializationPolicy longSerializationPolicy, String datePattern, int dateStyle,
      int timeStyle, List<TypeAdapterFactory> builderFactories,
      List<TypeAdapterFactory> builderHierarchyFactories,
      List<TypeAdapterFactory> factoriesToBeAdded,
          ToNumberStrategy objectToNumberStrategy, ToNumberStrategy numberToNumberStrategy) {
    this.excluder = excluder;
    this.fieldNamingStrategy = fieldNamingStrategy;
    this.instanceCreators = instanceCreators;
    this.constructorConstructor = new ConstructorConstructor(instanceCreators);
    this.serializeNulls = serializeNulls;
    this.complexMapKeySerialization = complexMapKeySerialization;
    this.generateNonExecutableJson = generateNonExecutableGson;
    this.htmlSafe = htmlSafe;
    this.prettyPrinting = prettyPrinting;
    this.lenient = lenient;
    this.serializeSpecialFloatingPointValues = serializeSpecialFloatingPointValues;
    this.longSerializationPolicy = longSerializationPolicy;
    this.datePattern = datePattern;
    this.dateStyle = dateStyle;
    this.timeStyle = timeStyle;
    this.builderFactories = builderFactories;
    this.builderHierarchyFactories = builderHierarchyFactories;
    this.objectToNumberStrategy = objectToNumberStrategy;
    this.numberToNumberStrategy = numberToNumberStrategy;

    List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();

    // built-in type adapters that cannot be overridden
    factories.add(TypeAdapters.JSON_ELEMENT_FACTORY);
    factories.add(ObjectTypeAdapter.getFactory(objectToNumberStrategy));

    // the excluder must precede all adapters that handle user-defined types
    factories.add(excluder);

    // users' type adapters
    factories.addAll(factoriesToBeAdded);

    // type adapters for basic platform types
    factories.add(TypeAdapters.STRING_FACTORY);
    factories.add(TypeAdapters.INTEGER_FACTORY);
    factories.add(TypeAdapters.BOOLEAN_FACTORY);
    factories.add(TypeAdapters.BYTE_FACTORY);
    factories.add(TypeAdapters.SHORT_FACTORY);
    TypeAdapter<Number> longAdapter = longAdapter(longSerializationPolicy);
    factories.add(TypeAdapters.newFactory(long.class, Long.class, longAdapter));
    factories.add(TypeAdapters.newFactory(double.class, Double.class,
            doubleAdapter(serializeSpecialFloatingPointValues)));
    factories.add(TypeAdapters.newFactory(float.class, Float.class,
            floatAdapter(serializeSpecialFloatingPointValues)));
    factories.add(NumberTypeAdapter.getFactory(numberToNumberStrategy));
    factories.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
    factories.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
    factories.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
    factories.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
    factories.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
    factories.add(TypeAdapters.CHARACTER_FACTORY);
    factories.add(TypeAdapters.STRING_BUILDER_FACTORY);
    factories.add(TypeAdapters.STRING_BUFFER_FACTORY);
    factories.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
    factories.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
    factories.add(TypeAdapters.URL_FACTORY);
    factories.add(TypeAdapters.URI_FACTORY);
    factories.add(TypeAdapters.UUID_FACTORY);
    factories.add(TypeAdapters.CURRENCY_FACTORY);
    factories.add(TypeAdapters.LOCALE_FACTORY);
    factories.add(TypeAdapters.INET_ADDRESS_FACTORY);
    factories.add(TypeAdapters.BIT_SET_FACTORY);
    factories.add(DateTypeAdapter.FACTORY);
    factories.add(TypeAdapters.CALENDAR_FACTORY);

    if (SqlTypesSupport.SUPPORTS_SQL_TYPES) {
      factories.add(SqlTypesSupport.TIME_FACTORY);
      factories.add(SqlTypesSupport.DATE_FACTORY);
      factories.add(SqlTypesSupport.TIMESTAMP_FACTORY);
    }

    factories.add(ArrayTypeAdapter.FACTORY);
    factories.add(TypeAdapters.CLASS_FACTORY);

    // type adapters for composite and user-defined types
    factories.add(new CollectionTypeAdapterFactory(constructorConstructor));
    factories.add(new MapTypeAdapterFactory(constructorConstructor, complexMapKeySerialization));
    this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
    factories.add(jsonAdapterFactory);
    factories.add(TypeAdapters.ENUM_FACTORY);
    factories.add(new ReflectiveTypeAdapterFactory(
        constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterFactory));

    this.factories = Collections.unmodifiableList(factories);
  }

  /**
   * Returns a new GsonBuilder containing all custom factories and configuration used by the current
   * instance.
   *
   * @return a GsonBuilder instance.
   */
}
