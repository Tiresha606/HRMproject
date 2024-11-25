package sr.unasat.hrm.services;


public interface EntityRepo<T> {
    void save(T entity);
    void findAll();
    void findById(int id);
    void update(T entity);
    void delete(T entity);

}
